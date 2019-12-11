package edu.vcu.patelas23;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.crypto.dsig.TransformException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CPU cpu;

        String programName, instruction = "";
        int memory, numProcesses, systemCycles;

        Scheduler scheduler = new Scheduler();
        cpu = new CPU();
        Scanner s = new Scanner(System.in);
        System.out.println("Programs:");
        listPrograms();

        System.out.println("Enter name of the desired program, or type 'create' to write a new program:");
        programName = s.nextLine();

        if (programName.equals("create")) {
            ProgramGenerator generator = new ProgramGenerator(s);

            System.out.println("Enter name of new program.");
            programName = s.nextLine();
            System.out.println("Enter the amount of memory required by the program.");
            memory = s.nextInt();
            //Create new program file
            System.out.println("Enter program script:");
            generator.createProgram(programName, memory);
        }

        System.out.println("Enter the number of processes to create:");
        numProcesses = s.nextInt();

        //Generate specified number of processes based on chosen program template
        //and add them to scheduler
//        scheduler.addBatch(ProcessGenerator.generateProcesses(numProcesses, programName));

        System.out.println("Enter number of cycles for CPU to execute before pausing:");
        systemCycles = s.nextInt();

        //Add processes generated from XML file to Scheduler
        cpu.load(ProcessGenerator.generateProcesses(numProcesses, programName));

        //execute CPU continuously
        //TODO: finish CPU execution
        while(systemCycles>0) {
            cpu.execute();
//            System.out.println("Executed");
            //update process table
            systemCycles--;
            if (systemCycles == 1) {
                System.out.println("CPU Status:");
                //TODO: finish toString implementation
//                   System.out.println(cpu.toString());
                System.out.println("Enter number of cycles to continue running.");
                System.out.println("Or enter 0 to exit.");
            }
        }

        System.out.println(scheduler.toString());
        //Exit
        s.close();
    } //Main

    public static void listPrograms() {
        String[] names;
        String name, filepath;

        filepath = System.getProperty("user.dir") + "/Programs/";
        File p = new File(filepath);
        names = p.list();

        assert names != null;
        for(String filename: names) {
            name = filename.substring(0, filename.lastIndexOf('.'));
            System.out.println(name);
        }
    }

} //Main
