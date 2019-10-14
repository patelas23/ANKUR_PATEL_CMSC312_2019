// SimulatedOS.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>
#include "Scheduler.h"
#include "Dispatcher.h"
#include "SimulatedOS.h"
#include "Process.h"

struct ProgramTemplate {
	std::string name;
	int runtime, memory;
};

int main()
{
	using namespace std;

	int num_of_processes, i = 0;
	int process_memory, cycles;

	string program_name, current_line, process_name, process_type;
	ifstream programFile;

	Scheduler scheduler;
	Dispatcher dispatcher;
	queue<string> instructions;
	queue<int> runtime;

	cout << "Enter name of program (omitting file extensions)\n";
	cout << " browser \n file_explorer \n media_player \n text_editor \n";
	cout << "Or enter 1 to create a new program.";
	cin >> program_name;

	if (program_name.compare("1")) {
		programGenerator();
	}

	cout << "Enter number of processes to create\n";
	cin >> num_of_processes;
	i = 0;


	programFile.open("../Program Files/" + program_name + ".txt");

	//Read contents of file word-by-word
	while (programFile >> current_line && current_line != "EXE") {
		if (current_line.compare("Name:") != 0) {
			programFile >> process_name;
		}
		else if (current_line.compare("Memory:") != 0) {
			programFile >> process_memory;
		}
		else {
			process_type = (current_line.substr(0, current_line.find(":")));
			programFile >> cycles;
			runtime.push(cycles);
		}
	}

	for (i = 0; i < num_of_processes; i++) {
		//Create new processes
		Process newProcess = Process(process_name, instructions, runtime, i);
	}

	programFile.close();

	return 0;
}


//Helper function which divides the given instruction queue into 
//multiple processes
int processGenerator(int x, std::queue<std::string> instructions) {
	if (!instructions.empty() && x!=0) {
		x--;

	}
}
// Helper function which uses master program template
// to randomly generate new job files
int programGenerator() {
	std::ofstream newFile;
	int calculate, io, j, cycles;
	std::string name;

	std::cout << "Enter name of new program : \n";
	std::cin >> name;
	newFile.open("../Program Files/" + name + ".txt");

	std::cout << "Enter number of CPU processes to populate: \n";
	std::cin >> calculate;
	newFile << calculate;

	std::cout << "Enter number of I/O processes to populate: \n";
	std::cin >> io;

	for (j = 0; j < calculate; j++) {
		cycles = rand() % 100;
		newFile << "CALCULATE: " << cycles;
	}
	for (j = 0; j < io; j++) {
		cycles = rand() % 100;
		newFile << "I/O: " << cycles;
	}
	newFile << "EXE";

	newFile.close();
	return 0;
}



// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu