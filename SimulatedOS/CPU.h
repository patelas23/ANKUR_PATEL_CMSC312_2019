#pragma once
#include "Process.h"
#include "Scheduler.h"
class CPU
{
public:
	//Pass process to CPU, removing previous process if present
	void setCurrentProcess(pcb p);
	//Returns the currently running process
	pcb getCurrentProcess(void);
	//Begin cycle of execution
	void execute(Process p);
	void execute(void);

private:
	int clock = 0;
	pcb currentProcess;
	std::string currentInstruction;
	int currentRuntime;
};

