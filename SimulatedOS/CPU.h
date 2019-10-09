#pragma once
#include <process.h>
#include "Scheduler.cpp"
class CPU
{
public:
	void execute(void);
	int increaseStep(void);
private:
	int clock = 0;
	pcb currentProcess;

};

