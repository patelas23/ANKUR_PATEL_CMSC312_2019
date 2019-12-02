package edu.vcu.patelas23;

public class Process {

    static class pcb {
        int pc = 0;
        int memory = 0;
        String name;
        String[] instructions;
        int[] runtimes;
        String state = "NEW";
        public pcb() {

        }
    }

    private String name;
    private String[] instructions;
    String state;
    private int[] runtimes;
    private int id;
    private int memory;

    public Process(String s, String[] i, int[] r, int id, int mem) {
        name = s;
        instructions = i;
        runtimes = r;
        memory = mem;
        this.id = id;

    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public void addMaskableInterrupt() {

    }
    public void addUnmaskableInterrupt() {

    }

}
