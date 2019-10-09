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
	if (!(instructions.empty())) {
		return instructions.pop();
	}
}

int Process::getId(void)
{
	return pid;
}


