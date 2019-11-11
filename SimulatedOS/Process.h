#pragma once
#include <string>
#include <queue>


class Process {
private:
	std::string name;
	std::string state;
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
	int getRuntime(void);
	std::string getState(void);
	int getId(void);
	void setInstruction(std::string s);
	void setRuntime(int x);
	void setState(std::string s);
};
