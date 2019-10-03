// SimulatedOS.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include <string>

int main()
{
	int num_of_processes;
	using namespace std;

	string program_name, current_line;
	ifstream programFile;

	cout << "Enter name of program (omitting file extensions)\n";
	cin >> program_name;

	cout << "Enter number of processes to create\n";
	cin >> num_of_processes;

	programFile.open("../Program Files/" + program_name + ".txt");

	while (getline(programFile, current_line)) {
		cout << current_line << "\n";
	}



	programFile.close();

	return 0;
}

// Helper function which uses master program template
// to randomly generate new job files
int programGenerator() {
	std::cout << "Finish implementation";
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
