#pragma once
#include "Process.h"
#include "Scheduler.h"
class Dispatcher
{
private:
	
	//int setState(Process p, std::string state);
public:
	pcb prev;
	pcb running;
	Dispatcher();
};
