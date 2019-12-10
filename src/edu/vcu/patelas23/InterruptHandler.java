package edu.vcu.patelas23;

public class InterruptHandler {
    private Process process;
    private IODevice keyboard, display;
    public InterruptHandler(Process p, int i) {
        switch (i){
            case(1):
                keyboard = new IODevice(p);
            case(2):
                display = new IODevice(p);
        }

    }
}
