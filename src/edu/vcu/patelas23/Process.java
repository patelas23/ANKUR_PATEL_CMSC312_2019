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
    private ArrayList<Pair<String, Integer>> stack;
    private int currentRuntime;
    String state;
    private int id;
    private int memory;
    private pcb block = new pcb();

    public Process() {
        id = globalID;
        globalID++;
    }


    public Process(String n, int m) {
        super();
        name = n + id;
        memory = m;
        block.memory = m;
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
        name = n;
    }
    public void setMemory(int m) {
        memory = m;
    }
    public void setStack(ArrayList<Pair<String, Integer>> s) {
        stack = s;
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

    // I/O interrupt handlers
    public void addMaskableInterrupt() {

    }
    public void addUnmaskableInterrupt() {

    }

    public void fork() {
        //create new thread
        Process newThread = new Process();
        //maintain the id of parent and child
        //both parent and child reference the same space in memory
        //add the new thread to job queue
    }

} //Process
