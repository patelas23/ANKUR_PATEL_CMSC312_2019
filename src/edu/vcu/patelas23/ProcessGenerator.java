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


    //Read XML file, returning process XML root node
    private static Node readXML(String name) {
        String filepath = System.getProperty("user.dir") + "/Programs/" + name + ".xml";
        File xmlFile = new File(filepath);

        //For opening.reading file
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder;

        //For parsing XML
        Node root, XMLProcess;
        NodeList nList;

        try {
            dbBuilder = dbFactory.newDocumentBuilder();
            Document document = dbBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            //Obtain root node from <Program>
            nList = document.getElementsByTagName("Program");
            root = nList.item(0);

            return root;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Return text content of specified element
    private static String getContent(String tag, Element e) {
        NodeList nList = e.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nList.item(0);
        return node.getNodeValue();
    }
    private static Pair<String, Integer> getInstruction(Node n) {
        Pair<String, Integer> instruction;
        String label;
        int runtime = 1;

        label = n.getNodeName();
        if (label.equals("CALC")) {
            runtime = Integer.parseInt(n.getTextContent());
        } else if (label.equals("I/O")) {
            runtime = 1;
            //TODO: Generate interrupt
        }
        instruction = new Pair<String, Integer>(label, runtime);
        System.out.println(instruction);
        return instruction;
    }


    private static ArrayList<Pair<String, Integer>> getScriptC(Element e) {
        ArrayList<Pair<String, Integer>> script = new ArrayList<>();
        Pair<String, Integer> instruction;
        NodeList scriptNode = e.getElementsByTagName("Script").item(0).getChildNodes();
        Node instructionNode = (Node) scriptNode.item(0);

        while (instructionNode.getNextSibling() != null) {
            if (instructionNode.getNodeType() == Node.ELEMENT_NODE) {
                instruction = getInstruction(instructionNode);
                script.add(instruction);
            }
            instructionNode = instructionNode.getNextSibling();
        }
        return script;
    }

    //Generates initial template process from XML file
    public static Process getTemplate(Node XMLProcess) {
        ArrayList<Pair<String, Integer>> stack = new ArrayList<>();
        Process p = new Process();
        Element element = (Element) XMLProcess;

        p.setName(getContent("Name", element));
        p.setMemory(Integer.parseInt(getContent("Memory", element)));

        //add each node within "script" to
//        stack = getScriptC(element);
        getScriptC(element);
        p.setStack(stack);

        return p;
    }

    //Generate subsequent processes from template
    public static Process getProcess(Process p) {
        ArrayList<Pair<String, Integer>> s;
        s = p.getStack();
        //randomize each value of s
        for (Pair<String, Integer> pair : s) {

        }
        return p;
    }

    //TODO: Finish new implementation of script loader
    private static ArrayList<Pair<String, Integer>> getScript(Node XMLProcess) {
        int runtime;
        NodeList nodes;
        nodes = XMLProcess.getChildNodes();
        System.out.println("Instruction: " + nodes.item(0).getNodeValue());
        //Find all nodes with either CALC, IO, or EXE

        return null;
    }

    private static ArrayList<Pair<String, Integer>> getScriptB(NodeList nList) {
        ArrayList<Pair<String, Integer>> stack = new ArrayList<>();
        int runtime;
        int length = nList.getLength();
        Node child;
        String instruction;

        for (int i = 2; i < length; i++) {
            child = nList.item(i);
            instruction = child.getLocalName();

            runtime = 1;

            if (instruction.equals("CALC") || instruction.equals("I/O")) {
                runtime = Integer.parseInt(child.getTextContent());
            }
            stack.add(new Pair<String, Integer>(instruction, runtime));
        }
        return stack;
    }



    public Pair<String, Integer> getRandomInstruction(Node n) {
        Pair<String, Integer> instruction;
        String label;
        int runtime = 1;

        label = n.getLocalName();
        if (label.equals("CALC")) {
            //Randomize runtime
            runtime = Integer.parseInt(n.getTextContent());
            runtime = (int) (Math.random() + 0.5 * runtime);
        } else if (label.equals("I/O")) {
            runtime = 1;
            //TODO: Generate interrupt
        } else if (label.equals("EXE")) {
            runtime = 1;
        } else {
            label = "EXE";
            runtime = 1;
        }
        instruction = new Pair<String, Integer>(label, runtime);
        return instruction;
    }


    public static Process[] generateProcesses(int n, String name) {
        Process[] batch;
        Process template;
        batch = new Process[n];
        Node XMLProcess;

        XMLProcess = readXML(name);
        assert XMLProcess != null;

        template = getTemplate(XMLProcess);

        for (int i = 0; i < n; i++) {
            //create processes with randomized values
//            batch[i] =

        }

        return batch;
    }

}
