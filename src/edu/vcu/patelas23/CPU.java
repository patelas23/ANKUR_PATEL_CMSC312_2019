package edu.vcu.patelas23;

import javafx.util.Pair;

public class CPU {
    private int clock;
    private Scheduler scheduler;
    private Process currentProcess = new Process();
    private Memory memory;

    private Pair<String, Integer> partialInstruction;
    private int partialRuntime;

    public CPU() {
        clock = 0;
        scheduler = new Scheduler();
        memory = new Memory();
    }

    public void load(Process[] pArray) {
        //Add processes to scheduler
        scheduler.addBatch(pArray);

        //Initialize scheduler queues
        scheduler.addAllToReady();
    }

    public void load(Process p) {
        scheduler.addProcess(p);
        scheduler.addAllToReady();
    }

    public void execute() {
        Pair<String, Integer> instruction;
        int runtime, calculationTime;
        String command;
        //If a new process is to be loaded, update memory
        //Peek scheduler to determine next process
        if (scheduler.getQuantum() == 0) {
            //get new process
            //if old process was running
            if (currentProcess.state.equals("RUN")) {
                //Replace process into scheduler queue, with partial instruction
                scheduler.addProcess(currentProcess);

            } else {
                //if there is no process yet
                currentProcess = scheduler.getNextProcess();
            }
            currentProcess = scheduler.getNextProcess();
            memory.load(currentProcess.getMemory());
            //if the current process has just entered or is otherwise ready
        } else if (currentProcess.state.equals("READY")) {
            instruction = currentProcess.getNextInstruction();
            runtime = (int) instruction.getValue();
            command = instruction.getKey();
            switch (command) {
                case ("CALC"):
                    runtime--;
                    partialInstruction = new Pair<String, Integer>(command, runtime);
                    partialRuntime = runtime;
                    currentProcess.state = "RUN";
                    if (runtime == 0) {
                        instruction = currentProcess.getNextInstruction();
                        partialRuntime = (int) instruction.getValue();
                    }
                    break;
                case ("IO"):
                    //add process to IO Event Queue
                    scheduler.addToIO(currentProcess);
                    break;
                case ("EXE"):
                    //clear this process from memory, load new process
                    memory.unload(currentProcess.getMemory());
                    currentProcess = scheduler.getNextProcess();
                    memory.load(currentProcess.getMemory());
                    //add process to exit queue?
                    break;
                default:
            }
            //call to dispatcher(process)
            //either replace process with partial instruction or keep processing this one
            //notify scheduler, checking for interrupts

        } else if (currentProcess.state.equals("RUN")) {
            if (partialRuntime == 0) {
                currentProcess.state = "READY";
            } else {
                partialRuntime--;
            }
        }


        //increase clock
        clock++;
        //check scheduler and IO devices for interrupts
        //if an interrupt has been generated,
        ////find the process associated, load it and mark it ready again
        if (interruptHandler.hasInterrupt()) {
            scheduler.addToReady(currentProcess);
            currentProcess = interruptHandler.getNextProcess();
            currentProcess.state = "READY";
        }
    }

    public int getClock() {
        return clock;
    }

    public void setCurrentProcess(Process p) {
        this.currentProcess = p;
    }

    public Process getCurrentProcess() {
        return this.currentProcess;
    }

}
