#pragma once
#include <string>
#include <queue>
#include "Process.h"

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

class Scheduler
{
private:
	std::queue <pcb> jobQueue;
	std::queue <pcb> readyQueue;
	std::queue <pcb> deviceQueue;

public:
	static int available_memory;

	Scheduler(void);

	void addProcess(Process p);
	pcb getNextProcess(void);

	std::queue<pcb> getReadyQueue(void);
	std::queue<pcb> getJobQueue(void);
	std::queue<pcb> getDeviceQueue(void);

};
