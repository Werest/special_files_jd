package task_3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import task_1.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//readString - BufferedReader и FileReader
//jsonToList - JSONParser, GsonBuilder, Gson
public class JParser {
    public static String readString(String path){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            return bufferedReader.lines()
                    .map(x -> x.replace(" ", ""))
                    .reduce(String::concat)
                    .orElse("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Employee> jsonToList(String json) throws ParseException {
        Gson gson = new GsonBuilder().create();
        JSONParser jsonParser = new JSONParser();

        JSONArray jsonArray = (JSONArray) jsonParser.parse(json);
        List<Employee> employeeList = new ArrayList<>();

        for(Object object : jsonArray){
            Employee employee = gson.fromJson(object.toString(), Employee.class);
            employeeList.add(employee);
        }
        return employeeList;
    }
}
