#pragma once
#include "Process.h"
#include "Scheduler.h"
class CPU
{
public:
	void setCurrentProcess(pcb p);
	pcb getCurrentProcess(void);
	
	void execute(Process p);
	void execute(void);
	int increaseStep(void);

private:
	int clock = 0;
	int quantum = 15;
	pcb currentProcess;
	std::string currentInstruction;
	int currentRuntime;
};

