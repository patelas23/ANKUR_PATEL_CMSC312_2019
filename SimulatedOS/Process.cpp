#include "Process.h"


Process::Process() {
}
Process::Process(std::string n, std::queue<std::string> i, int id)
{
	this->name = n;
	this->instructions = i;
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
	return nextInstruction;
}

std::queue<std::string> Process::getInstructions(void)
{
	return this->instructions;
}

int Process::getId(void)
{
	return pid;
}


