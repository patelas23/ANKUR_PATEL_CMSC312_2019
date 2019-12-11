package edu.vcu.patelas23;

//CLass to directly give control of CPU to processes,
//assigning them as the scheduler sees fit
public class Dispatcher {
    private Process currentProcess, newProcess;

    public Dispatcher() {
        System.out.println("Dispatcher instantiated");
    }

    public void loadProcess(Process p) {
        //if scheduler has not interrupted, return current process
        //otherwise, currentProcess = scheduler.swapProcess(currentProcess)
    }

    public boolean isEmpty() {
        return true;
    }

}
