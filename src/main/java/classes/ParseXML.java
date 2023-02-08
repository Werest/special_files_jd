package classes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseXML {
    public static List<Employee> parseXML(String filepath) throws ParserConfigurationException, IOException, SAXException {
        List<Employee> employeeList = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(filepath);

        Element element = document.getDocumentElement();
        NodeList nodeList = element.getElementsByTagName("employee");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element item = (Element) nodeList.item(i);
            employeeList.add(new Employee(
                    Long.parseLong(item.getElementsByTagName("id").item(0).getTextContent()),
                    item.getElementsByTagName("firstName").item(0).getTextContent(),
                    item.getElementsByTagName("lastName").item(0).getTextContent(),
                    item.getElementsByTagName("country").item(0).getTextContent(),
                    Integer.parseInt(item.getElementsByTagName("age").item(0).getTextContent())
                    ));
        }
        return employeeList;
    }
}
