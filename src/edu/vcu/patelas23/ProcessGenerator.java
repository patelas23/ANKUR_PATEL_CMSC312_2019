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
import java.util.ArrayList;

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
    public static Process getTemplate(String name) {
        ArrayList<Pair<String, Integer>> stack;
        Process p = new Process();
        String instruction;
        int length, runtime;
        Node child;

        NodeList nList = readXML(name);
        assert nList != null;

        length = nList.getLength();

        p.setName(nList.item(0).getNodeValue());
        p.setMemory(Integer.parseInt(nList.item(1).getNodeValue()));

        //create arraylist of Pairs <String, int> :: <Instruction, Runtime>
//        stack = new ArrayList<Pair<String, Integer>>();
        stack = getScript

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
            stack.add(new Pair<String, Integer>(instruction, runtime));
        }
        p.setStack(stack);
        return p;
    }

    private static ArrayList<Pair<String, Integer>> getScript(NodeList nList) {
        ArrayList<Pair<String, Integer>> stack = new ArrayList<>();
        int runtime;
        int length = nList.getLength();
        Node child;
        String instruction;

        for (int i =2; i<length; i++) {
            child = nList.item(i);
            instruction = child.getLocalName();

            runtime = 1;

            if(instruction.equals("CALC") || instruction.equals("I/O")) {
                runtime = Integer.parseInt(child.getTextContent());
            }
            stack.add(new Pair<String, Integer>(instruction, runtime));
        }
        return stack;
    }

    public static ArrayList<Pair<String, Integer>> getRandomScript(NodeList nList) {
        ArrayList<Pair<String, Integer>> stack = new ArrayList<>();

        int runtime;
        int length = nList.getLength();
        Node child;
        String instruction;

        for (int i =2; i<length; i++) {
            child = nList.item(i);
            instruction = child.getLocalName();

            runtime = 1;

            //Randomize runtime of each operation
            if(instruction.equals("CALC") || instruction.equals("I/O")) {
                runtime = (int) (Math.random() * (runtime / 2) + runtime);
            }
            stack.add(new Pair<String, Integer>(instruction, runtime));
        }
        return stack;
    }

    //Generate subsequent processes from template
    public static Process getProcess(Process p) {
        return p;
    }

    public static Process[] generateProcesses(Process template, int n) {
        Process[] batch;
        batch = new Process[n];

        for(int i=0;i<n;i++) {
            //create processes with randomized values
//            batch[i] =

        }

        return batch;
    }

}
