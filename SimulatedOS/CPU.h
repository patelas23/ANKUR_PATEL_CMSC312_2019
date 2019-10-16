#pragma once
#include <process.h>
#include "Scheduler.cpp"
class CPU
{
public:
	void setProcess(pcb p);
	pcb getProcess(void);
	void execute(Process p);

	int increaseStep(void);
private:
	int clock = 0;
	int quantum = 15;
	pcb currentProcess;
	std::string currentInstruction;
	int currentRuntime;
};

