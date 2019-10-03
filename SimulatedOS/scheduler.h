#pragma once
#include <string>
class Scheduler
{
	struct PCB;
	static Scheduler* instance;
	static int available_memory;
	int CreateProcess(std::string name, int memory);
	int LoadFromReady(int* queue, int runtime);

};

