#pragma once
#include "Process.h"
#include "Scheduler.h"
class CPU
{
public:
	//Pass process to CPU, removing previous process if present
	pcb setCurrentProcess(pcb p);
	//Returns the currently running process
	pcb getCurrentProcess(void);
	void execute(Process p);
	//Begin cycle of execution
	void execute(void);

private:
	int clock = 0;
	pcb currentProcess;
	std::string currentInstruction;
	int currentRuntime;
};

