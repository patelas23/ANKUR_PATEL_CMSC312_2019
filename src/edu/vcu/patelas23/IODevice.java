package edu.vcu.patelas23;
/*
    Class to generate system interrupts from various
    simulated I/O devices
 */
public class IODevice {
    //Associate each device with a single process
    private Process process;
    private String name;


    public IODevice(int id, Process p) {
        switch(id) {
            case (1):
                name = "Keyboard";
        }

    }

    public static class Keyboard {
        public Keyboard() {

        }
    }
}
