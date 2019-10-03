#pragma once
#include <string>
#include <queue>
class Scheduler
{
const int TOTAL_MEM = 4096;

public:
	struct pcb {
		std::string name;
		std::string state;
		int pc;
		int memory;
	};
	static int available_memory;
	Scheduler( void );

	int createprocess(std::string name, int cycles);
	int loadfromready(int* queue, int runtime);

};

