package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;


//readString - BufferedReader и FileReader
//jsonToList - JSONParser, GsonBuilder, Gson
public class JParser {
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

    public static String listToJson(List<Employee> employeeList){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(employeeList, new TypeToken<List<Employee>>() {}.getType());
    }
}
