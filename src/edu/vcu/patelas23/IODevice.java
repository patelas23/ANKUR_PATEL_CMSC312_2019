package edu.vcu.patelas23;
/*
    Class to generate system interrupts from various
    simulated I/O devices
 */
public class IODevice {
    //Associate each device with a single process
    private Process process;
    private String name;


    public IODevice(Process p) {
    }

    public IODevice(String s) {
        name = s;
    }

    //randomly generate true or false
    public boolean interrupt() {
        double n = Math.random() * 10;
        if(n<5) {
            return false;
        }
        else {
            return true;
        }
    }

}
