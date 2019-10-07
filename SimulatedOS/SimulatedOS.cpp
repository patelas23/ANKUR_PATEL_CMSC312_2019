// SimulatedOS.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include <string>
#include "Scheduler.h"
#include "Dispatcher.h"

struct ProgramTemplate {
	std::string name;
	int runtime, memory;
};

int main()
{
	using namespace std;

	int num_of_processes, i = 0;

	string program_name, current_line, process_name;
	ifstream programFile;

	Scheduler scheduler;
	Dispatcher dispatcher;

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
	while (programFile >> current_line) {
		cout << current_line << "\n";
		/*if (current_line.compare("Name: ") != 0) {
			programFile >> a->name;
		}
		else if (current_line.compare("CALCULATE") != 0) {
			programFile >> a->time;
			a->type = "CALCULATE";
			num_of_processes--;
		}
		else if (current_line.compare("I/O") != 0) {
			programFile >> a->time;
			a->type = "I/O";
			num_of_processes--;
		}
		else if (current_line.compare("EXE") != 0) {
			break;
		}*/
	}

	for (i = 0; i < num_of_processes; i++) {
		//Create new processes
	}

	programFile.close();

	return 0;
}

// Helper function which uses master program template
// to randomly generate new job files
int programGenerator() {
	std::ofstream newFile;
	int calculate, io, j;
	std::string name;

	std::cout << "Enter name of new program : \n";
	std::cin >> name;
	newFile.open("../Program Files/" + name + ".txt");

	std::cout << "Enter number of CPU processes to populate: \n";
	std::cin >> calculate;
	newFile << calculate;

	std::cout << "Enter number of I/O processes to populate: \n";
	std::cin >> io;

	return 0;
}

int processGenerator() {
	return 0;
}

int generateProcess() {
	return 0;
}

int createProcess(std::string name, int cycles) {
	return 0;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu