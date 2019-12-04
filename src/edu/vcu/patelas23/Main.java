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
        System.out.println("Programs:");
        listPrograms();

        System.out.println("Enter name of the desired program, or type 'create' to write a new program:");
        programName = s.next();
        if (programName.equals("create")) {
            ProgramGenerator generator = new ProgramGenerator(s);

            System.out.println("Enter name of new program.");
            programName = s.next();
            System.out.println("Enter the amount of memory required by the program.");
            memory = s.nextInt();
            //Create new program file
            generator.createProgram(programName, memory);
        }
        //open program file (name.XML)
        createProcesses(programName);
        //add process(es) to scheduler

        //execute CPU continuously
        //Exit
        s.close();
    }


    //Helper function for generating new processes
    public static void createProcesses(String name) {
//        System.out.println("Enter the number of processes to create");
        //for (0->numOfProcesses)
        ////Process p = new Process
        //Return list of processes
        ProcessGenerator.getTemplate(name);
    }

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
