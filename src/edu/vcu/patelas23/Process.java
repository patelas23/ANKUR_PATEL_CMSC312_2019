package edu.vcu.patelas23;

import javafx.util.Pair;

import java.util.ArrayList;

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
//    private Pair<String, Integer>[] stack;
    private ArrayList<Pair<String, Integer>> stack;
    String state;
    private int id;
    private int memory;
    private pcb block;

    public Process() {
        id = globalID;
        globalID++;
    }


    public Process(String n, int m) {
        super();
        name = n;
        memory = m;
    }

    public Process(String s, String[] i, int mem) {
        super();
        name = s;
        instructions = i;
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
    public void setStack(Pair<String, Integer>[] s) {
        this.stack = s;
    }

    public void addMaskableInterrupt() {

    }
    public void addUnmaskableInterrupt() {

    }

}
