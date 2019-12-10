package edu.vcu.patelas23;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

public class ProgramGenerator {

    //TODO: Add script tag before script section
    private Scanner scan;

    public ProgramGenerator(Scanner scan) {
        this.scan = scan;
    }

    public void createProgram(String name, int memory) {
        //if processes > 1 {create child processes}
        String filepath = System.getProperty("user.dir") + "/Programs/" + name + ".xml";

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("Program");
            document.appendChild(root);

            //Name element
            Element programName = document.createElement("Name");
            programName.appendChild(document.createTextNode(name));
            root.appendChild(programName);

            //Memory element
            Element programMem = document.createElement("Memory");
            programMem.appendChild(document.createTextNode(String.valueOf(memory)));
            root.appendChild(programMem);

            //Parse instruction strings
            addInstructions(document, root);

            //create xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filepath));

            //Command line output for debugging:
            //StreamResult result = new StreamResult(System.out);

            //Transform the DOM object to XML
            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }

    //Member function for handling input of batch script
    private void addInstructions(Document d, Element root) {
        String in = "";
        Element instruction;
        int cycles;
        while (!in.contains("EXE")) {
            System.out.println("Enter next instruction: (CALC, IO, or EXE)");
            System.out.print("->");
            in = scan.next();
            switch (in) {
                case "CALC":
                    instruction = d.createElement("CALC");
                    System.out.println("Enter number of execution cycles");
                    cycles = scan.nextInt();
                    instruction.appendChild(d.createTextNode(String.valueOf(cycles)));
                    root.appendChild(instruction);
                    break;
                case "IO":
                    instruction = d.createElement("IO");
                    System.out.println("1 - Keyboard interrupt");
                    System.out.println();
                    System.out.println("Enter device ID to associate with this process");
                    cycles = scan.nextInt();
                    instruction.appendChild(d.createTextNode(String.valueOf(cycles)));
                    root.appendChild(instruction);
                    break;
                case "EXE":
                    instruction = d.createElement("EXE");
                    root.appendChild(instruction);
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }


    }

    private void generateIOEvent() {
        //0 - non-maskable
        ////wait for interrupt immediately
        //else > 0 :maskable
        ////wait for specified number of interrupts
    }

}
