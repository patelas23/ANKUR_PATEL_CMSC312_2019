package edu.vcu.patelas23;
import java.util.*;

public class Scheduler {
    //if quantum=0
    ////swap process()

    private Deque<Process> jobQueue;
    private Deque<Process> readyQueue;
    private Deque<Process> waitingQueue;

    private Deque<Process> processQueue;

    private int quantum;
    private Dispatcher dispatcher;

    public Scheduler() {
        //instantiate queues
        jobQueue = new ArrayDeque<Process>();
        readyQueue = new ArrayDeque<Process>();
        waitingQueue = new ArrayDeque<Process>();
        dispatcher = new Dispatcher();
        //quantum should be set while a process loads
        quantum = 0;
    }

    public Process getNextProcess() {
        //Return the next scheduled process
        return jobQueue.getFirst();
//        return readyQueue.peek();

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

    private void addToReady(Process p) {
        p.state = "READY";
        readyQueue.add(p);
    }

    public void addAllToReady() {
        for (Process process:jobQueue) {
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

    //Reset quantum when new process loads

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Process p: readyQueue) {
            result.append(p.getName());
            result.append("\n");
            result.append(p.getMemory());
            result.append("\n");
        }
        return result.toString();
    }


}
