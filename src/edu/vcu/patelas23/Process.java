package edu.vcu.patelas23;

import javafx.util.Pair;

import java.util.ArrayList;

public class Process {
    static int globalID = 0;

    static class pcb {
        int pc = -1;
        int memory = 0;
        String name;
        String[] instructions;
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
    public ArrayList<Pair<String, Integer>> getStack() {
        return stack;
    }

    public void setName(String n) {
        this.name = n;
    }
    public void setMemory(int m) {
        this.memory = m;
    }
    public void setStack(ArrayList<Pair<String, Integer>> s) {
        this.stack = s;
    }

    public Pair<String, Integer> getNextInstruction() {
        block.pc++;
        return stack.get(block.pc);
    }
    public int getMemory() {
        return memory;
    }

    public void setLastInstruction(Pair<String, Integer> partialInstruction) {
        stack.remove(stack.size()-1);
        stack.add(partialInstruction);
    }

    public void addMaskableInterrupt() {

    }
    public void addUnmaskableInterrupt() {

    }

}
