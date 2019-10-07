#include "scheduler.h"
#include <iostream>

Scheduler::Scheduler(void) {
	
}

int Scheduler::createProcess(std::string name, int cycles, int memory)
{
	pcb newProcess;
	newProcess.time = cycles;
	newProcess.memory = memory;
	jobQueue.push(newProcess);

	return 0;
}