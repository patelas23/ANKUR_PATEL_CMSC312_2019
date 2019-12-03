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
    public static void readXML(String name) {
        String filepath = System.getProperty("user.dir") + "/Programs/" + name + ".xml";
        File xmlFile = new File(filepath);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder;
        Node root;
        NodeList instructions, nodes, template;

        try {
            dbBuilder = dbFactory.newDocumentBuilder();
            Document document = dbBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
//            System.out.println("Root element: "+document.getDocumentElement().getNodeName());
            root = document.getDocumentElement();
            template = root.getChildNodes();
            getProcess(template);


        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }


    }

    public void generateProcesses() {

        //create process objects based on file attributes
    }

    public static Process getProcess(Node t) {
        Pair[] instructions;
        Process p = new Process();
        String instruction;
//        String[] instructions;
        int length, runtime;
//        int[] runtimes;

        Node child;
        NodeList nList = t.getChildNodes();
        length = nList.getLength();

        p.setName(nList.item(0).getNodeValue());
        p.setMemory(Integer.parseInt(nList.item(1).getNodeValue()));
        
        //create array of javatuples <String, int> :: <Instruction, Runtime> pair
        instructions = new Pair[length - 2];
        Pair<String, Integer> pair = Pair.with("CALC", 20);

        //Iterate over the rest of the nodes to generate script
        for (int i = 2; i < length; i++) {
            //By default, any instruction will employ the CPU for at least 1 cycle
            runtime = 1;
            child = nList.item(i);
            instruction = child.getLocalName();

            //CALC and I/O instructions have variable CPU usage
            if (instruction.equals("CALC") || instruction.equals("I/O")) {
                runtime = Integer.parseInt(child.getTextContent());
            }
            instructions[i - 2] = Pair.with(instruction, runtime);
        }
        return p;
    }

    private static String[] getElementValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag);
//        Node node = (Node) nodes.item(0);

        return node.getNodeValue();
    }
}
