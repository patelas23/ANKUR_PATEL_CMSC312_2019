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
	//Returns current system time
	int getClock(void);

	//* Begin cycle of execution, or
	//* preempt currently running process
	pcb execute(pcb p);
	void execute(void);

private:
	int clock = 0;
	pcb currentProcess;
	std::string currentInstruction;
	int currentRuntime = 0;
};

