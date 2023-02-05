package task_2;

import org.xml.sax.SAXException;
import task_1.Employee;
import task_1.ParserCSV;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    //2
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        List<Employee> employeeList = ParseXML.parseXML("F:\\ProjectJava\\special_files\\src\\main\\java\\task_2\\data.xml");
        String JSON = ParserCSV.listToJson(employeeList);
        ParserCSV.writeString(JSON, "data2.json");
    }
}
