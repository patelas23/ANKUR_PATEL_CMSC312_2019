#include "scheduler.h"
#include <iostream>

Scheduler::Scheduler(void) {
	jobQueue;
}

void Scheduler::addProcess(Process p)
{
	pcb processBlock;
	processBlock.pc = p.getPointer();
	processBlock.pc = 0;
	processBlock.runtime = p.getId();
	processBlock.stack = p.getInstructions();
	jobQueue.push(processBlock);
}

pcb Scheduler::getNextProcess(void)
{
	jobQueue.pop();
	return jobQueue.front();
}

std::queue<pcb> Scheduler::getReadyQueue(void)
{
	return readyQueue;
}

std::queue<pcb> Scheduler::getJobQueue(void)
{
	return jobQueue;
}

std::queue<pcb> Scheduler::getDeviceQueue(void)
{
	return deviceQueue;
}
