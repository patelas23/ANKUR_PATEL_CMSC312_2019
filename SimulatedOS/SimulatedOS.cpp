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
#include <time.h>

int programGenerator(void);

struct ProgramTemplate {
	std::string name;
	int runtime, memory;
};

int main()
{
	using namespace std;

	int num_of_processes, i = 0;
	int processMemory, processRuntime, cycles, delim;

	string program_name, current_line, word, processName, process_type;
	ifstream programFile;

	srand (time(NULL));

	Scheduler scheduler;
	Dispatcher dispatcher;
	queue<string> instructions;
	queue<int> runtime;

	cout << "Enter name of program (omitting file extensions)\n";
	cout << " browser \n file_explorer \n media_player \n text_editor \n";
	//cout << "Or enter 1 to create a new program.\n";

	cin >> program_name;

	if (program_name == "1") {
		programGenerator();
	}


	programFile.open("../Program Files/" + program_name + ".txt");

	cout << "Enter number of processes to create" << endl;
	cin >> num_of_processes;
	i = 0;

	//Read in basic program parameters
	std::getline(programFile, current_line);
	processName = current_line.substr(current_line.find("Name") + 5);

	std::getline(programFile, current_line);
	processRuntime = stoi(current_line.substr(current_line.find("Total Runtime")+15));

	std::getline(programFile, current_line);
	processMemory = stoi(current_line.substr(current_line.find("Memory") + 8));

	//Read program script word-by-word
	while (programFile >> word) {
		instructions.push(word);
		cout << word << endl;
		if (word == "EXE") {
			break;
		}
		else if (word == "CALC") {
			programFile >> cycles;
			cycles -= rand() % cycles;
			runtime.push(cycles);
		}
		else if (word == "I/O") {
			programFile >> cycles;
			cycles -= rand() % cycles;
			runtime.push(cycles);
		}
		else if (word == "acquire") {
			//denote critical section
		}
		else if (word == "release") {
			//end of critical section
		}
		else {
			programFile >> word;
			continue;
		}
		
	}


	cout << runtime.front() << endl;
	cout << instructions.front() << endl;
	runtime.pop();
	instructions.pop();
	cout << runtime.front() << endl;
	cout << instructions.front() << endl;

	
	

	//for (i = 0; i < num_of_processes; i++) {
		//Create new processes
		//Process newProcess = Process(processName, instructions, runtime, i);
		//scheduler.addProcess(newProcess);
	//}

	//cout << scheduler.getNextProcess().stack.front();
	programFile.close();

	return 0;
}


//Helper function which divides the given instruction queue into 
//multiple processes
int processGenerator(int x, std::queue<std::string> instructions) {
	if (!instructions.empty() && x!=0) {
		x--;
	}
	return x;
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