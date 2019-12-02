package edu.vcu.patelas23;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class ProcessGenerator {
    //Read XML file
    //create processes based on it
    public void readXML(String name) {
        String filepath = System.getProperty("user.dir") + "/Programs/" + name + ".xml";
        File xmlFile = new File(filepath);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder;

        try {
            dbBuilder = dbFactory.newDocumentBuilder();
            Document document = dbBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            System.out.println("Root element: "+document.getDocumentElement().getNodeName());

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }


    }
    public void generateProcesses() {

    }
}
