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

int CPU::getClock(void)
{
	return clock;
}

void CPU::execute(void)
{
	if (currentProcess.pc == 0) {
		clock++;//
		//currentProcess = Scheduler.getNextProcess();
		return;
	}
	else {
		if (currentRuntime <= 0) {
			currentInstruction = currentProcess.pc->getNextInstruction();
			currentRuntime = currentProcess.pc->getRuntime();
		}
		clock++;
		currentRuntime--;
	}

	//REMOVE
	while (true) {
		currentInstruction = currentProcess.stack.front();
		if (currentInstruction.compare("CALCULATE")) {
			currentRuntime = currentProcess.pc->getRuntime();
			while (currentRuntime > 0) {

			}
		}
	}
}

void CPU::execute(pcb p)
{
	//Loop should run continuously, and update the scheduler time quantum
	while (true) {
		currentInstruction = p.pc->getNextInstruction();
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



