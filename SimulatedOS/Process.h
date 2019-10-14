#pragma once
#include <string>
#include <queue>


class Process {
private:
	std::string name;
	std::queue<std::string> instructions;
	std::queue<int> runtime;
	struct inst {
		std::string type;
		int runtime;
	};
	int pid;

	
public:
	Process();
	Process(std::string n, std::queue<std::string> i, std::queue<int> r, int id);

	std::string getname(void);
	std::string getNextInstruction(void);
	std::queue<std::string> getInstructions(void);
	Process* getPointer(void);
	int getRuntime(void);
	int getId(void);
};
