#include "scheduler.h"
#include <iostream>

Scheduler::Scheduler(void) {
	//nothin
}

int Scheduler::createProcess(std::string name, int cycles, int memory)
{
	return 0;
}

int Scheduler::addProcess(pcb newProcess) {
	std::cout << "Successfully called addprocess on " << newProcess.name;
	return 0;
}

