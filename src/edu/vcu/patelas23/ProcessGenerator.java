package edu.vcu.patelas23;

import javafx.util.Pair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ProcessGenerator {
    //Read XML file
    //create processes based on it
    private static NodeList readXML(String name) {
        String filepath = System.getProperty("user.dir") + "/Programs/" + name + ".xml";
        File xmlFile = new File(filepath);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder;
        Node root;

        try {
            dbBuilder = dbFactory.newDocumentBuilder();
            Document document = dbBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
//            System.out.println("Root element: "+document.getDocumentElement().getNodeName());
            root = document.getDocumentElement();
            return root.getChildNodes();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Generates initial template process from XML file
    private static Process getTemplate(String name) {
        Pair<String, Integer>[] instructions;
        Process p = new Process();
        String instruction;
        int length, runtime;
        Node child;

        NodeList nList = readXML(name);
        assert nList != null;

        length = nList.getLength();

        p.setName(nList.item(0).getNodeValue());
        p.setMemory(Integer.parseInt(nList.item(1).getNodeValue()));

        //create array of Pairs <String, int> :: <Instruction, Runtime>
        instructions = new Pair<String, Integer>[length - 2];

        //Iterate over the rest of the nodes to generate script
        for (int i = 2; i < length; i++) {

            child = nList.item(i);
            instruction = child.getLocalName();

            //By default, any instruction will employ the CPU for at least 1 cycle
            runtime = 1;
            //CALC and I/O instructions have variable CPU usage
            if (instruction.equals("CALC") || instruction.equals("I/O")) {
                runtime = Integer.parseInt(child.getTextContent());
            }
            instructions[i - 2] = new Pair<String, Integer>(instruction, runtime);
        }
        p.setStack(instructions);
        return p;
    }

    //Generate subsequent processes from template
    public static Process getProcess(Process p) {
        return p;
    }

    public static Process[] generateProcesses(int n) {
        Process template;
        Process[] batch;
        batch = new Process[n];



        for(int i=0;i<n;i++) {
            //create processes with randomized values
//            batch[i] =

        }

        return batch;
    }

}
