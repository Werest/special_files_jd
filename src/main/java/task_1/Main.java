package task_1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "F:\\ProjectJava\\special_files\\src\\main\\java\\task_1\\data.csv";
        List<Employee> employeeList = ParserCSV.parseCSV(columMapping, fileName);

        String json = ParserCSV.listToJson(employeeList);
        ParserCSV.writeString(json, "data.json");
    }
}
