package classes;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JParserTest {

    @Test
    void jsonToList() throws ParseException {
        String json = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}]";
        List<Employee> employeeList = JParser.jsonToList(json);

        List<Employee> exEmployeeList = new ArrayList<>();
        exEmployeeList.add(new Employee(1, "John", "Smith", "USA", 25));

        Assertions.assertEquals(exEmployeeList, employeeList);
    }

    @Test
    void jsonToListHam() throws ParseException {
        String json = "[{\"id\":55,\"firstName\":\"Konstantin\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":80}]";
        List<Employee> employeeList = JParser.jsonToList(json);

        List<Employee> exEmployeeList = new ArrayList<>();
        exEmployeeList.add(new Employee(55, "Konstantin", "Smith", "USA", 80));

        assertThat(exEmployeeList, equalTo(employeeList));
    }

    @ParameterizedTest
    @MethodSource("addSource")
    void testListToJson(List<Employee> employeeList, String jsonEx){
        Assertions.assertEquals(jsonEx, JParser.listToJson(employeeList));
    }

    @ParameterizedTest
    @MethodSource("addSource")
    void testListToJsonHam(List<Employee> employeeList, String jsonEx){
        assertThat(jsonEx, equalTo(JParser.listToJson(employeeList)));
    }


    static Stream<Arguments> addSource(){
        String json = """
                [
                  {
                    "id": 55,
                    "firstName": "Konstantin",
                    "lastName": "Smith",
                    "country": "USA",
                    "age": 80
                  }
                ]""";

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(55, "Konstantin", "Smith", "USA", 80));

        String json2 = """
                [
                  {
                    "id": 67,
                    "firstName": "Anna",
                    "lastName": "Smith",
                    "country": "RU",
                    "age": 33
                  }
                ]""";

        List<Employee> employeeList2 = new ArrayList<>();
        employeeList2.add(new Employee(67, "Anna", "Smith", "RU", 33));

        return Stream.of(
                Arguments.of(employeeList, json),
                Arguments.of(employeeList2, json2)
        );
    }

}