package edu.vcu.patelas23;

public class Process {
    static int globalID = 0;

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
    private pcb block;

    public Process() {
        id = globalID;
        globalID++;
    }

    public Process(String s, String[] i, int[] r, int mem) {
        super();
        name = s;
        instructions = i;
        runtimes = r;
        memory = mem;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public void setName(String n) {
        this.name = n;
    }
    public void setInstructions(String[] arr) {
        this.instructions = arr;
    }
    public void setMemory(int m) {
        this.memory = m;
    }

    public void addMaskableInterrupt() {

    }
    public void addUnmaskableInterrupt() {

    }

}
