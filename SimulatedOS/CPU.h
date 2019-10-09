#pragma once
#include <process.h>
#include "Scheduler.cpp"
class CPU
{
public:
	void setProcess(pcb p);
	pcb getProcess(void);
	void execute(void);
	int increaseStep(void);
private:
	int clock = 0;
	int quantum = 15;
	pcb currentProcess;

};

