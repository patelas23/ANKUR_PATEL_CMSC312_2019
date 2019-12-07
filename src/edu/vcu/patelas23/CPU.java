package edu.vcu.patelas23;

public class CPU {
    //round robin time quantum should interrupt CPU processing
    private int clock;

    private Process currentProcess;

    public CPU() {
        clock = 0;
        Scheduler scheduler = new Scheduler();
        Dispatcher dispatcher = new Dispatcher();
    }

    public void load(Process[] pArray) {

    }

    public void load(Process p) {

    }

    public void execute(Process.pcb p) {


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
