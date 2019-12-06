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

            root = document.getDocumentElement();
            return root.getChildNodes();

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Generates initial template process from XML file
    public static Process getTemplate(NodeList XMLProcess) {
        ArrayList<Pair<String, Integer>> stack;
        Process p = new Process();

        p.setName(XMLProcess.item(0).getNodeValue());
        p.setMemory(Integer.parseInt(XMLProcess.item(1).getNodeValue()));

        stack = getScript(XMLProcess);
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

    private static ArrayList<Pair<String, Integer>> getScript(NodeList nList) {
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

    public Pair<String, Integer> getInstruction(Node n) {
        Pair<String, Integer> instruction;
        String label;
        int runtime = 1;

        label = n.getLocalName();
        if(label.equals("CALC")) {
            runtime = Integer.parseInt(n.getTextContent());
        }
        else if(label.equals("I/O")) {
            runtime = 1;
            //TODO: Generate interrupt
        }
        instruction = new Pair<String, Integer>(label, runtime);
        return instruction;
    }

    public Pair<String, Integer> getRandomInstruction(Node n) {
        Pair<String, Integer> instruction;
        String label;
        int runtime = 1;

        label = n.getLocalName();
        if(label.equals("CALC")) {
            //Randomize runtime
            runtime = Integer.parseInt(n.getTextContent());
            runtime = (int)(Math.random() + 0.5 * runtime);
        }
        else if(label.equals("I/O")) {
            runtime = 1;
            //TODO: Generate interrupt
        }
        else if(label.equals("EXE")) {
            runtime = 1;
        }
        else{
            label = "EXE";
            runtime = 1;
        }
        instruction = new Pair<String, Integer>(label, runtime);
        return instruction;
    }


    public static Process[] generateProcesses(Process t, int n, String name) {
        Process[] batch;
        Process template;
        batch = new Process[n];
        NodeList XMLProcess;

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
