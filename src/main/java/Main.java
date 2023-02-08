import classes.*;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, ParseException {
        String[] columMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> employeeList = ParserCSV.parseCSV(columMapping, fileName);

        String json = JParser.listToJson(employeeList);
        WriteReadFile.writeString(json, "data.json");

        //2
        employeeList = ParseXML.parseXML("data.xml");
        String JSON = JParser.listToJson(employeeList);
        WriteReadFile.writeString(JSON, "data2.json");

        //3
        JSON = WriteReadFile.readString("data.json");

        employeeList = JParser.jsonToList(JSON);
        employeeList.forEach(System.out::println);
    }
}