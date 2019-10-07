#pragma once
struct pcb {
	int pc, memory, time;
	bool ioStatus = false; //No associated I/O by default
	enum state {
		READY,
		WAITING
	};
};
