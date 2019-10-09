#include "CPU.h"

void CPU::setProcess(pcb p)
{
	currentProcess = p;
}

pcb CPU::getProcess(void) {
	return currentProcess;
}

void CPU::execute(void)
{
	int currentlyRunning;
	if (quantum > 0) {
	}

}

int CPU::increaseStep(void)
{
	clock++;
	return clock;
}
