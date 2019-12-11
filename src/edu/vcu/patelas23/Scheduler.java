package edu.vcu.patelas23;

import javafx.util.Pair;

import java.util.*;

public class Scheduler {
    //if quantum=0
    ////swap process()
    private static final int QUANTUM = 5;

    private Deque<Process> jobQueue;
    private Deque<Process> readyQueue;
    private Deque<Process> IOQueue;
    private Deque<Process> waitingQueue;

    private Deque<Process> processQueue;

    private int quantum;
    private Dispatcher dispatcher;

    public Scheduler() {
        //instantiate queues
        jobQueue = new ArrayDeque<Process>();
        readyQueue = new ArrayDeque<Process>();
        IOQueue = new ArrayDeque<Process>();
        waitingQueue = new ArrayDeque<Process>();

        dispatcher = new Dispatcher();
        //quantum should be set while a process loads
        quantum = 0;
    }

    public Process getNextProcess() {
        //Return the next scheduled process
        //Rest time quantum as new process is being laoded
        Process nextProcess;
        quantum = QUANTUM;
        nextProcess = readyQueue.removeFirst();
        if(readyQueue.isEmpty()) {
            return null;
        }
        return nextProcess;
    }

    public boolean isEmpty() {
        return (readyQueue.isEmpty());
    }

    public void getNextProcess(Process p) {
        //add given process back to queue
        //getNextProcess();
    }

    //add given process to corresponding waiting queue,
    //then return next process
    public void getNextProcess(Process p, int flag) {
        //waitingQueue(flag).add(p)
        //getNextProcess();
    }

    public void addProcess(Process p) {
        jobQueue.add(p);
    }

    public void addBatch(Process[] pArray) {
        //add list of processes to queue
        jobQueue.addAll(Arrays.asList(pArray));
    }

    public void addToIO(Process p) {
        p.state = "WAIT";
        readyQueue.remove(p);
        IOQueue.add(p);
    }

    public Process getNextIO() {
        if (IOQueue.isEmpty()) {
            IOQueue.add(generateQuitter());
//            return new Process
        }
        return IOQueue.removeFirst();
    }

    private Process generateQuitter() {
        Process quitter;
        ArrayList<Pair<String, Integer>> stack;

        quitter = new Process();
        stack = new ArrayList<Pair<String, Integer>>();
        stack.add(new Pair<>("EXE", 1));
        quitter.setStack(stack);

        return quitter;
    }

    public void addToReady(Process p) {
        p.state = "READY";
        readyQueue.add(p);
    }

    public void addAllToReady() {
        for (Process process : jobQueue) {
            addToReady(process);
        }
    }

    public void removeProcess(Process p) {

    }

    //Update round-robin quantum on each execute() cycle
    public int getQuantum() {
        quantum--;
        return quantum;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Process p : readyQueue) {
            result.append(p.getName());
            result.append("\n");
            result.append(p.getMemory());
            result.append("\n");
        }
        return result.toString();
    }


}
