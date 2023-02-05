package task_3;

import org.json.simple.parser.ParseException;
import task_1.Employee;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        //3
        List<Employee> employeeList;
        String JSON = JParser.readString("F:\\ProjectJava\\special_files\\data.json");

        System.out.println(JSON);

        employeeList = JParser.jsonToList(JSON);
        employeeList.forEach(System.out::println);
    }
}
