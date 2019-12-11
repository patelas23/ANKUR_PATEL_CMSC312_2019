package edu.vcu.patelas23;

//Class to represent virtual memory, with demand paging
//Only CPU has mutator rights
//Process either address + read request
//or address + data and write request
//Address space is allocated per process, shared between threads
//each page represents one byte of memory
public class Memory {
    public static int MAX_MEM = 4096;
    public static int REMAINING_MEM = 4096;
    //subtract process.memory from remaining memory on load

    public Memory() {

    }
    public Memory(int mem) {
        MAX_MEM = mem;
    }

    public int load(int n) {
        REMAINING_MEM -= n;
        return REMAINING_MEM;
    }

    public int unload(int n) {
        REMAINING_MEM += n;
        return REMAINING_MEM;
    }

    public void read(int address) {

    }

    public void write(int address, int data) {

    }

}
