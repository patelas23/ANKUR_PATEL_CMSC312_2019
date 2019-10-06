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
	std::queue <int> readyQueue;

	Scheduler( void );

	int createProcess(std::string name, int cycles);
	int addProcess( void );
	int loadFromReady(int runtime);

};

