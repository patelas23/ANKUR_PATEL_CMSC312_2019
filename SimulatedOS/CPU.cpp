#include "CPU.h"

pcb CPU::setCurrentProcess(pcb p)
{
	pcb temp = {};
	temp.state = "EXIT";
	if (currentProcess.state == "RUN") {
		currentProcess.state = "WAITING";
		currentProcess.pc->setInstruction(currentInstruction);
		currentProcess.pc->setRuntime(currentRuntime);
		currentRuntime = 0;
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
		currentInstruction = p.stack.front();
		if (currentInstruction.compare("EXE") == 0) {
			currentProcess.state = "EXIT";
			return currentProcess;
		}
		currentRuntime = p.instructions.front();
		p.instructions.pop();
		currentProcess.state = "RUN";
	}
	else {
		if (!p.instructions.empty() && currentRuntime <= 0) {
			currentInstruction = currentProcess.stack.front();
			currentProcess.stack.pop();

			currentRuntime = currentProcess.instructions.front();
			currentProcess.instructions.pop();
		}

		clock++;
	}
	if (currentInstruction.compare("CALC") == 0) {
		currentProcess.state = "RUN";
		currentRuntime--;
	} 
	else if (currentInstruction.compare("I/O") == 0) {
		//send process to waiting queue
		currentProcess.state = "WAIT";
		return currentProcess; //TODO: scheduler checks state as it readmits the process
	}
	else if (currentInstruction.compare("wait") == 0) {
		//wait semaphore
	}
	else if (currentInstruction.compare("signal") == 0) {
		//signal semaphore
	}
	else if (currentInstruction.compare("EXE") == 0) {
		currentProcess.state = "EXIT";
	}

}



