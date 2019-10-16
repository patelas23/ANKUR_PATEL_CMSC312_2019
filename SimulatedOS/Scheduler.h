#pragma once
#include <string>
#include <queue>
#include "Process.h"

struct pcb {
	std::queue<std::string> stack;
	int memory = 0;
	Process* pc = 0;
	bool ioStatus = false; //No associated I/O by default
	enum state {
		NEW,
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
