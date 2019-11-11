#include "CPU.h"

pcb CPU::setCurrentProcess(pcb p)
{
	pcb temp = {};
	if (currentProcess.state == "RUN") {
		currentProcess.state = "WAITING";
		currentProcess.pc->setInstruction(currentInstruction);
		currentProcess.pc->setRuntime(currentRuntime);
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

pcb CPU::execute(pcb p)
{
	if (currentProcess.pc == 0) {
		clock++;
		currentProcess = p;
		currentInstruction = p.pc->getNextInstruction();
		currentRuntime = p.pc->getRuntime();
		currentProcess.state = "RUN";
	}
	else {
		if (currentRuntime <= 0) {
			currentInstruction = currentProcess.pc->getNextInstruction();
			currentRuntime = currentProcess.pc->getRuntime();
		}

		clock++;
	}
	if (currentInstruction.compare("CALC")) {
		currentProcess.state = "RUN";
		currentRuntime--;
	} 
	else if (currentInstruction.compare("I/O")) {
		//send process to waiting queue
		currentProcess.state = "WAIT";
		return currentProcess; //TODO: scheduler checks state as it readmits the process
	}
	else if (currentInstruction.compare("wait")) {
		//wait semaphore
	}
	else if (currentInstruction.compare("signal")) {
		//signal semaphore
	}
	else if (currentInstruction.compare("EXE")) {
		currentProcess.state = "EXIT";
	}

}



