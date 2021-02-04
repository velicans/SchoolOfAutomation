package json.example;

public class JsonTest {
    public static void main(String[] args) {
        JsonExample example = new JsonExample();
        System.out.println("JSON example");
        example.readJSON("JsonExample");

        System.out.println("\n JSON Example With List \n ");
        example.readJSONWithList("jsonWithList");
    }
}
