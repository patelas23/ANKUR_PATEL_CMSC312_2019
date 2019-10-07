#pragma once
#include <string>
#include <queue>
class Scheduler
{
	const int TOTAL_MEM = 4096;
public:
	struct pcb {
		std::string state, type;
		int pc, memory, time;
		bool ioStatus = false; //No associated I/O by default
	};
	static int available_memory;

	Scheduler(void);
	int createProcess(std::string name, int cycles, int memory);
	int addProcess(pcb  newProcess);

private:
	std::queue <pcb> jobQueue;
	std::queue <pcb> readyQueue;
	std::queue <pcb> deviceQueue;
};
