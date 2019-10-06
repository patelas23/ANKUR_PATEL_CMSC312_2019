#pragma once
#include <string>
#include <queue>
class Scheduler
{
	const int TOTAL_MEM = 4096;
public:
	struct pcb {
		std::string name, state, type;
		int pc, memory, time;
		
	};
	static int available_memory;

	Scheduler( void );
	int createProcess(pcb &newProcess);
	//int createProcess(std::string name, int cycles);

	int addProcess( void );
	int loadProcess(void);
	pcb loadFromReady( void );

private:
	std::queue <pcb> jobQueue;
	std::queue <pcb> readyQueue;
	std::queue <pcb> deviceQueue;
};

