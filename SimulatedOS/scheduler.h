#pragma once
#include <string>
#include <queue>
#include "Process.h"
class Scheduler
{
private:
	std::queue <pcb> jobQueue;
	std::queue <pcb> readyQueue;
	std::queue <pcb> deviceQueue;

public:
	static int available_memory;

	Scheduler(void);

	int createProcess(std::string name, int cycles, int memory);

	std::queue <pcb> getReadyQueue(void) {
		return readyQueue;
	}

};
