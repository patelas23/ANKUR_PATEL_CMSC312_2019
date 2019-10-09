#pragma once
#include <string>
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

class Process {
private:
	//instruction queue
public:
	Process(std::string name, std::queue<std::string> instructions);


};
