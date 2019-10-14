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
	while (quantum > 0) {
		currentInstruction = currentProcess.pc->getNextInstruction();
		if (currentInstruction.compare("CALCULATE")) {
			currentRuntime = currentProcess.pc->getRuntime();
			while (currentRuntime) {
				quantum--;
				currentRuntime--;
			}
		}
		else if (currentInstruction.compare("I/O")) {

		}
	}

}

int CPU::increaseStep(void)
{
	clock++;
	return clock;
}
