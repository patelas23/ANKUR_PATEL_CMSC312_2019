#pragma once
#include <string>


class Process {
private:
	std::string name;
	std::queue<std::string> instructions;
	int pid;

	struct pcb {
		int runtime = 0;
		int memory = 0;
		int pc = 0;
		bool ioStatus = false; //No associated I/O by default
		enum state {
			READY,
			WAITING
		};
	};
public:
	
	Process(std::string n, std::queue<std::string> i, int id);

	std::string getname(void);
	std::string getNextInstruction(void);
};
