package json.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JsonExampleTest {

    JsonExample example = new JsonExample();

    @Test
    @DisplayName("Check JSON file location")

    public void readJSONFile() {
        Assertions.assertDoesNotThrow(() -> example.readJSONFile("file"));
    }

    @Test
    @DisplayName("Read JSON object")

    public void readJSONFObject() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> example.readJSONObject(example.readJSONFile("file")));

    }
}