// SimulatedOS.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include <string>
#include "Scheduler.h"

int main()
{
	int num_of_processes, i;
	using namespace std;

	string program_name, current_line;
	ifstream programFile;

	Scheduler scheduler;


	cout << "Enter name of program (omitting file extensions)\n";
	cin >> program_name;

	cout << "Enter number of processes to create\n";
	cin >> num_of_processes;
	i = 0;

	programFile.open("../Program Files/" + program_name + ".txt");

	//Read contents of file line by line
	/*while (getline(programFile, current_line)) {
		cout << current_line << "\n";

		cout << i;
		i++;
	}*/

	//Read contents of file word-by-word
	while (programFile >> current_line) {
		Scheduler::pcb* a;
		cout << current_line << "\n";
		if (current_line.compare("Name:") != 0) {
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
		}
		scheduler::addProcess(a);
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
	std::ifstream newFile;
	int calculate, io, j;
	std::string name;

	std::cout << "Enter name of new program: \n";
	std::cin >> name;

	std::cout << "Enter number of CPU processes to populate: \n";
	std::cin >> calculate;

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

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
