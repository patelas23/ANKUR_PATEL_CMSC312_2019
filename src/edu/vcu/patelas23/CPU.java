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
    }

    public void execute() {
        Pair<String, Integer> instruction, partialInstruction;
        int runtime;
        //Peek scheduler to determine next process
        if (scheduler.getQuantum() == 0) {
            //get new process
            //dispatcher.loadProcess(Scheduler)
        } else {
            instruction = currentProcess.getNextInstruction();
            runtime = (int) instruction.getValue();
            if(instruction.getKey().equals("CALC")) {
                //Calculate
                runtime--;
                //partially executed calculate statement
                partialInstruction = new Pair<String, Integer>(instruction.getKey(), runtime);
            }
            else if (instruction.getKey().equals("I/O")) {
                //add to waiting queue
                //wait for I/O signal
            }
            else if (instruction.getKey().equals("EXE")) {
                //add process to exit queue
            }
            //call to dispatcher(process)
            //either replace process with partial instruction or keep processing this one

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

}
