#include "scheduler.h"
#include <iostream>

Scheduler::Scheduler(void) {
}

void Scheduler::addProcess(Process p)
{
	pcb processBlock;
	processBlock.pc = p.getPointer();
	processBlock.pc = 0;
	processBlock.stack = p.getInstructions();
	processBlock.state = "NEW";
	jobQueue.push(processBlock);
}

pcb Scheduler::getNextProcess(void)
{
	pcb currentBlock;
	if (!jobQueue.empty()) {
		currentBlock = jobQueue.front();
		jobQueue.pop();
	}
	readyQueue.push(currentBlock);
	return currentBlock;
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
