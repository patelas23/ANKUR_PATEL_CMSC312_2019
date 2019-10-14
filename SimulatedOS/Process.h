#pragma once
#include <string>
#include <queue>


class Process {
private:
	std::string name;
	std::queue<std::string> instructions;
	int pid;

	
public:
	Process();
	Process(std::string n, std::queue<std::string> i, int id);

	std::string getname(void);
	std::string getNextInstruction(void);
	std::queue<std::string> getInstructions(void);
	Process* getPointer(void);
	int getId(void);
};
