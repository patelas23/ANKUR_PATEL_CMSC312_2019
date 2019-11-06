#include "CPU.h"

void CPU::setCurrentProcess(pcb p)
{
	currentProcess = p;
}

pcb CPU::getCurrentProcess(void) {
	return currentProcess;
}

void CPU::execute(Process p)
{
	while (quantum > 0) {
		currentInstruction = currentProcess.pc->getNextInstruction();
		if (currentInstruction.compare("CALCULATE")) {
			currentRuntime = currentProcess.pc->getRuntime();
			while (currentRuntime>0) {
				quantum--;
				currentRuntime--;
				increaseStep();
			}
		}
		else if (currentInstruction.compare("I/O")) {
			
		}
	}

}

void CPU::execute(void)
{
}

int CPU::increaseStep(void)
{
	clock++;
	return clock;
}
