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
        String programName, instruction = "";
        int memory;

        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of the desired program, or type 'create' to write a new program:");
        programName = s.next();
        if (programName.equals("create")) {//createProgram();
            ProgramGenerator generator = new ProgramGenerator(s);

            System.out.println("Enter name of new program.");
            programName = s.next();
            System.out.println("Enter the amount of memory required by the program.");
            memory = s.nextInt();
            //Create new program file
            generator.createProgram(programName, memory);
        }
        //open program file (name.XML)
        //read program file line by line
        //TODO: create new process(es) based on program file
        createProcesses();
        //add process(es) to scheduler
        //execute CPU continuously
        //Exit
        s.close();
    }


    //Helper function for generating new processes
    public static void createProcesses() {
        System.out.println("Enter the number of processes to create");
        //for (0->numOfProcesses)
        ////Process p = new Process
        //Return list of processes
    }

} //Main
