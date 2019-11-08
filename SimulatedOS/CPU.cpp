#include "CPU.h"

pcb CPU::setCurrentProcess(pcb p)
{
	pcb temp = {};
	if (currentProcess.state == "RUN") {
		currentProcess.state = "BLOCKED";
		temp = currentProcess;
		
	}
	currentProcess = p;
	return temp;


}

pcb CPU::getCurrentProcess(void) {
	return currentProcess;
}

void CPU::execute(Process p)
{
	//Loop should run continuously, and somehow update the scheduler time quantum
	while (true) {
		currentInstruction = currentProcess.pc->getNextInstruction();
		if (currentInstruction.compare("CALCULATE")) {
			currentRuntime = currentProcess.pc->getRuntime();
			while (currentRuntime>0) {
				currentRuntime--;
			}
		}
		else if (currentInstruction.compare("I/O")) {
			
		}
	}

}

void CPU::execute(void)
{
	if (currentProcess.pc == 0) {
		return;
	}
	while (true) {
		currentInstruction = currentProcess.stack.front();
	}
}
