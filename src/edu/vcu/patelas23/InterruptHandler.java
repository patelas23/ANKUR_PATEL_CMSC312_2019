package edu.vcu.patelas23;

public class InterruptHandler {
    private Process process;
    private IODevice keyboard, display;
    private IODevice[] devices;

    public boolean hasInterrupt() {
        for(int i=0;i<devices.length;i++) {
            if(devices[i].interrupt()) {
                return true;
            }
        }
        return false;
    }

    public InterruptHandler() {
        keyboard = new IODevice("Keyboard");
        display = new IODevice("Display");
        devices = new IODevice[] {keyboard, display};
    }

    public InterruptHandler(Process p, int i) {
        super();
        //if device is not already associated with a process
        //if it is, add the process to waiting queue (set state to WAIT)
        if (false) {

        } else {
            switch (i) {
                case (1):
                    keyboard = new IODevice(p);
                case (2):
                    display = new IODevice(p);
            }
        }


    }
}
