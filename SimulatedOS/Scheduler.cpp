#include "scheduler.h"
#include <iostream>

Scheduler::Scheduler(void) {
}

void Scheduler::init(void)
{
	pcb temp;
	while (!jobQueue.empty()) {
		temp = jobQueue.front();
		temp.state = "READY";
		readyQueue.push(temp);
		jobQueue.pop();
	}
}

void Scheduler::wait(semaphore* S)
{
	S->value--;
	if (S->value < 0) {
		//S->list.push_back(); Push most recent process
		//block()
	}
}

void Scheduler::signal(semaphore* S)
{
	S->value++;
	if (S->value <= 0) {
		//remove process from list
		//wakeup(process);
	}
}

void Scheduler::addProcess(Process &p)
{
	pcb processBlock;
	processBlock.pc = &p;
	processBlock.stack = p.getInstructions();
	processBlock.state = "NEW";
	if (processBlock.memory < mem.remaining_mem) {
		mem.remaining_mem -= processBlock.memory;
		jobQueue.push(processBlock);
	}
	else {
		deviceQueue.push(processBlock);
	}
}

void Scheduler::addProcess(pcb &b) {
	if (b.state == "EXIT") {
		return;
	}
	else {
		b.state = "READY";
		readyQueue.push(b);
	}
}

void Scheduler::resetQuantum(void)
{
	quantum = 15;
}

pcb Scheduler::getNextProcess(void)
{
	pcb currentBlock;
	currentBlock.state = "EXIT";
	resetQuantum();
	if (!readyQueue.empty()) {
		currentBlock = readyQueue.front();
		currentBlock.state = "READY";
		readyQueue.pop();
	}
	else {
		return currentBlock;
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
