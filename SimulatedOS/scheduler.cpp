#include "scheduler.h"

class Scheduler {
	struct PCB
	{
		std::string state;
		std::string name;
		int pc;
		int memory;
	};
	static Scheduler* instance;
	const int AVAILABLE_MEM = 4096;
	static int* ready_queue, waiting_queue;

	int LoadFromReady(int* queue, int runtime)
	{
		return 0;
	}

};


