#include "scheduler.h"
#include <iostream>

Scheduler::Scheduler(void) {
}

void Scheduler::addProcess(Process p)
{
	pcb processBlock;
	processBlock.pc = &p;
	processBlock.stack = p.getInstructions();
	processBlock.state = "NEW";
	jobQueue.push(processBlock);
}

//Function for replacing a partially completed process into the queue
void Scheduler::addProcess(pcb b) {
	b.state = "WAITING";
	readyQueue.push(b);
}

void Scheduler::resetQuantum(void)
{
	quantum = 15;
}

pcb Scheduler::getNextProcess(void)
{
	pcb currentBlock;
	resetQuantum();
	if (!readyQueue.empty()) {
		currentBlock = readyQueue.front();
		currentBlock.state = "READY";
		readyQueue.pop();
	}
	else if (!jobQueue.empty()) {
		currentBlock = jobQueue.front();
		currentBlock.state = "READY";
		jobQueue.pop();
	}
	else {
		return;
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
