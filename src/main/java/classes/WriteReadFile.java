package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReadFile {
    public static void writeString(String json, String fileName){
        try (FileWriter fileWriter = new FileWriter(fileName)){
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
}
