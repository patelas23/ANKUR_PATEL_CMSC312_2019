#include "Process.h"
#include <queue>


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
	return std::string();
}

std::string Process::getNextInstruction(void)
{
	return std::string();
}

int Process::getId(void)
{
	return pid;
}




