package classes;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import static org.junit.jupiter.api.Assertions.*;
class WriteReadFileTest {

    //Нужно создать файл json
    File file;
    String filename;

    @BeforeEach
    void setUp() throws IOException {
        filename = "test.json";
        file = new File(filename);
        if(file.createNewFile()){
            System.out.println("Файл " + filename + " создан!");
        }
    }

    @Test
    void readString() {
        assertNotNull(WriteReadFile.readString(file.getPath()));
        assertNull(WriteReadFile.readString("inotinproject.json"));
    }

    @Test
    void readStringHamcrest(){
        assertThat(WriteReadFile.readString(file.getPath()), notNullValue());
        assertThat(WriteReadFile.readString("asdasd.json"), nullValue());
    }

    @After
    public void deleteTestFile(){
        if(file.delete())
        {
            System.out.println("Файл " + filename + " удалён!");
        }
    }
}