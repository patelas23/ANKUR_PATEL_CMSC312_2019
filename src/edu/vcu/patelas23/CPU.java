package edu.vcu.patelas23;

import javafx.util.Pair;

public class CPU {
    private int clock;
    private Scheduler scheduler;
    private Process currentProcess;

    public CPU() {
        clock = 0;
        scheduler = new Scheduler();
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
        Pair<String, Integer> instruction, partialInstruction;
        int runtime;
        String command;
        //If a new process is to be loaded, update memory
        //Peek scheduler to determine next process
        if (scheduler.getQuantum() == 0) {
            //get new process
            //dispatcher.loadProcess(Scheduler)
        } else if (currentProcess.state.equals("READY")) {
            instruction = currentProcess.getNextInstruction();
            runtime = (int) instruction.getValue();
            command = instruction.getKey();
            switch (command) {
                case ("CALC"):
                    runtime--;
                    partialInstruction = new Pair<String, Integer>(command, runtime);
                    break;
                case ("IO"):
                    //add process to IO Event Queue
                    scheduler.addToIO(currentProcess);
                    break;
                case ("EXE"):
                    //clear this process from memory, load new process
                    currentProcess = swap(currentProcess);
                    //add process to exit queue?
                    break;
                default:
            }
            //update clock

            //call to dispatcher(process)
            //either replace process with partial instruction or keep processing this one
            //notify scheduler, checking for interrupts
            //dispatcher loads from scheduler and checks io devices for interrupts

        }
        //increase clock
        clock++;
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

    public Process swap(Process p) {
        
    }

}
