package edu.vcu.patelas23;

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
        Process p = new Process();
        String[] instructions;
        int length;

        NodeList nList = t.getChildNodes();
        length = nList.getLength();

        p.setName(nList.item(0).getNodeValue());
        p.setMemory(Integer.parseInt(nList.item(1).getNodeValue()));

        //Iterate over the rest of the nodes to generate script
        for (int i = 2; i < length; i++) {
            
        }


        if (t.getNodeType() == Node.ELEMENT_NODE) {
            Element e = (Element) t;
//            p.setName(getElementValue("Name", e));
//            p.setInstructions

        }

        return p;
    }

    private static String[] getElementValue(String tag, Element element) {
        NodeList nodes = element.getElementsByTagName(tag);
//        Node node = (Node) nodes.item(0);

        return node.getNodeValue();
    }
}
