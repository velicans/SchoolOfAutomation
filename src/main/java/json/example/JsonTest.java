package json.example;

import java.io.FileNotFoundException;

public class JsonTest {
    public static void main(String[] args) throws FileNotFoundException {

        JsonExample example = new JsonExample();

        System.out.println("Simple JSON example");
        example.readJSONObject(example.readJSONFile("JsonExample"));


        System.out.println("\n JSON Example With List \n ");
        example.readJSONObject(example.readJSONFile("jsonWithList"));

    }
}
