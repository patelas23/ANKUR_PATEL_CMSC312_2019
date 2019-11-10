#pragma once
#include "Process.h"
class Dispatcher
{
private:
	
	//int setState(Process p, std::string state);
public:
	Process& prev;
	Dispatcher(Process p);
};
