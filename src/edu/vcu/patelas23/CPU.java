package edu.vcu.patelas23;

public class CPU {
    //round robin time quantum should interrupt CPU processing
    private int clock;

    private Process currentProcess;

    public CPU() {
        clock = 0;
    }

    public void execute(Scheduler.pcb p) {

    }
    public Process execute(){
        //Check interrupt handler
        //execute next instruction from current process (in dispatcher)
        clock++;
        //update state of process if applicable
        return currentProcess;
    }

    public int getClock() {
        return clock;
    }

    public void setCurrentProcess() {

    }
    public Process getCurrentProcess() {
        return this.currentProcess;
    }

}
