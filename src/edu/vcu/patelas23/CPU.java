package edu.vcu.patelas23;

import javafx.util.Pair;

public class CPU {
    private int clock;
    private InterruptHandler interruptHandler;
    private Scheduler scheduler;
    private Process currentProcess = new Process();
    private Memory memory;

    private Pair<String, Integer> partialInstruction;
    private int partialRuntime;

    public CPU() {
        clock = 0;
        scheduler = new Scheduler();
        memory = new Memory();
        interruptHandler = new InterruptHandler();
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
        int runtime;
        String command;
        //If quantum has run up, or if the system is just starting
        if (scheduler.getQuantum() == 0) {
            //if old process was running
            if (currentProcess.state.equals("RUN")) {
                //Replace process into scheduler queue, with partial instruction
                currentProcess.setLastInstruction(partialInstruction);
                scheduler.addProcess(currentProcess);
            } else if (currentProcess.state.equals("READY")) {
                //if there is no process yet
                scheduler.addToReady(currentProcess);
                currentProcess = scheduler.getNextProcess();
            }
            currentProcess = scheduler.getNextProcess();
            memory.load(currentProcess.getMemory());

            //if the current process has just entered or is otherwise ready
        } else if (currentProcess.state == null){
            currentProcess = scheduler.getNextProcess();
        }
        else if (currentProcess.state.equals("READY")) {
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
            //get first process from IO waiting queue
            currentProcess = scheduler.getNextIO();
            currentProcess.state = "READY";
        }
    }

    public int getClock() {
        return clock;
    }

    public Process getCurrentProcess() {
        return currentProcess;
    }

}
