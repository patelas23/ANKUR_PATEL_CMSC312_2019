#pragma once
#include <string>
#include <queue>
#include <vector>
#include "Process.h"

//Process Control Block
//Maintains information about each process in the system
struct pcb {
	std::queue<std::string> stack;
	std::string state = "NEW"; //(NEW), READY, WAITING, BLOCKED, RUN, EXIT
	int memory = 0;
	Process *pc = 0;
	bool ioStatus = false; //No associated I/O by default
};

typedef struct {
	int value;
	//List<Process> list;
	std::vector<Process*> list;
} semaphore;



class Scheduler
{
private:
	//processes in system
	std::queue <pcb> jobQueue;
	//processes residing in main memory
	std::queue <pcb> readyQueue;
	//processes waiting for I/O
	std::queue <pcb> deviceQueue;

public:
	static const int AVAILABLE_MEM = 256;
	int quantum = 15;
	//Implement counting semaphore

	Scheduler(void);

	//Semaphore operations
	void wait(semaphore *S);
	void signal(semaphore* S);

	//insert a new process into the Job Queue
	void addProcess(Process p);
	//Replace a partially completed process into the ready queue
	void addProcess(pcb &b);

	void resetQuantum(void);

	//Returns the next scheduled process, preempting if needed
	pcb getNextProcess(void);

	//Returns the specified queue
	std::queue<pcb> getReadyQueue(void);
	std::queue<pcb> getJobQueue(void);
	std::queue<pcb> getDeviceQueue(void);

};
