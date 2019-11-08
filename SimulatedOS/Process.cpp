#include "Process.h"


Process::Process() {
	pid = 0;
}
Process::Process(std::string n, std::queue<std::string> i, std::queue<int> r, int id)
{
	this->name = n;
	this->instructions = i;
	this->runtime = r;
	this->pid = id;
	this->state = "NEW";
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

int Process::getRuntime(void) {
	int r = runtime.front();
	runtime.pop();
	return r;
}

std::string Process::getState(void)
{
	return this->state;
}

int Process::getId(void)
{
	return pid;
}

void Process::setState(std::string s)
{
	this->state = s;
	return;
}

//MAYBE
//void run(CPU c, this*) { c.add(this.nextInstruction(), c.decrementTimer  }
