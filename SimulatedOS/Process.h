#pragma once
#include <string>


class Process {
private:
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
	std::string name;
	Process(std::string name, std::queue<std::string> instructions);
	std::string getname(void);
	std::string getNextInstruction(void);
	int getPC(void);
	int totalRuntime(void);


};
