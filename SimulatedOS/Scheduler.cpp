#include "scheduler.h"
#include <iostream>

struct pcb {
	int runtime = 0;
	int memory = 0;
	int pc = 0;
	bool ioStatus = false; //No associated I/O by default
	enum state {
		READY,
		WAITING
	};
};

Scheduler::Scheduler(void) {
	jobQueue;
}

int Scheduler::addProcess(Process p)
{
	pcb processBlock;
	processBlock.pc = 0;
	processBlock.runtime = p.getId;
	jobQueue.push(processBlock);
}

Process Scheduler::getNextProcess(void)
{
	return jobQueue.front;
}

std::queue<pcb> Scheduler::getReadyQueue(void)
{
	return readyQueue;
}
