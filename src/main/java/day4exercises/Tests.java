package day4exercises;


import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class Tests {

    JsonParser parser;
    JSONObject obj;

    @BeforeEach
    void init(){
        parser= new JsonParser("File",".txt");

    }

    @Test
    @DisplayName("CreateJsonObj")
    @Before
    public void createJsonObj(){
        obj = parser.jsonParser();
    }
    
    @Test
    @DisplayName("parserFileTest")
    public void parserFileTest(){
        Assert.assertEquals(parser.path, Paths.get(System.getProperty("user.dir"), "PracticeFiles", "File" + ".txt"));
        Assertions.assertNotNull(obj,"Check if object is created");
    }
    



}
