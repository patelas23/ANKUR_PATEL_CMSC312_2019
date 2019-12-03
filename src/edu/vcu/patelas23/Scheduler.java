package edu.vcu.patelas23;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {

    private Queue<Process> jobQueue;
    private Queue<Process> readyQueue;
    private Queue<Process> waitingQueue;

    private Queue<Process> processQueue;

    public Scheduler() {
        //instantiate queues
        jobQueue = new LinkedList<>();
        readyQueue = new LinkedList<>();
        waitingQueue = new LinkedList<>();
    }
    public void schedule() {
        //Check and prepare all queues
    }

    public void addProcess(Process p) {
        jobQueue.add(p);
    }

    public void addBatch() {
        //add list of processes to queue
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


}
