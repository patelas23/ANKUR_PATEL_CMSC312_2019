#include "Process.h"


Process::Process() {
}
Process::Process(std::string n, std::queue<std::string> i, std::queue<int> r, int id)
{
	this->name = n;
	this->instructions = i;
	this->runtime = r;
	this->pid = id;
}



std::string Process::getname(void)
{
	return name;
}

std::string Process::getNextInstruction(void)
{
	std::string nextInstruction;
	if (!(instructions.empty())) {
		nextInstruction = instructions.front();
		instructions.pop();
	}
	else {
		nextInstruction = "EXE";
	}
	return nextInstruction;
}

std::queue<std::string> Process::getInstructions(void)
{
	return this->instructions;
}

Process* Process::getPointer(void) {
	return this;
}

int Process::getRuntime(void) {
	int r = runtime.front();
	runtime.pop();
	return r;
}

int Process::getId(void)
{
	return pid;
}


