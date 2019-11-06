#pragma once
#include <string>
#include <queue>
#include "Process.h"

struct pcb {
	std::queue<std::string> stack;
	std::string state; //NEW, READY, WAITING, BLOCKED, RUN
	int memory = 0;
	Process* pc = 0;
	bool ioStatus = false; //No associated I/O by default
};

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

	Scheduler(void);

	void addProcess(Process p);
	pcb getNextProcess(void);

	std::queue<pcb> getReadyQueue(void);
	std::queue<pcb> getJobQueue(void);
	std::queue<pcb> getDeviceQueue(void);

};
