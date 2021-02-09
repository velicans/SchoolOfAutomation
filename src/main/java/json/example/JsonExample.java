package json.example;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonExample {

    /**
     * This method takes a String, converts it into a file and uses the file to make JSONObjects.
     *
     * @param filename
     * @return JSONObject
     */
    public JSONObject readJSONFile(String filename) {
        Path fileLocation = Paths.get(System.getProperty("user.dir"), "Practice Files", filename + ".json");
        File file = new File(String.valueOf(fileLocation));

        try {
            String productList = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            if (!productList.isEmpty()) {
                return new JSONObject(productList);
            }
        } catch (IOException e) {
            System.out.println("File not found!Please check filename");
        }


        return null;
    }

    /**
     * This method takes a JSONObject, reads and returns its content.
     * This method is RECURSIVE.
     *
     * @param jsonObject
     */
    public void readJSONObject(JSONObject jsonObject) {
        if (jsonObject != null) {
            System.out.println("Product Name: " + jsonObject.get("product_name"));
            System.out.println("Supplier: " + jsonObject.get("supplier"));
            System.out.println("Quantity: " + jsonObject.get("quantity"));
            System.out.println("Unit Cost: " + jsonObject.get("unit_cost"));
            if (jsonObject.has("listJSon")) {
                System.out.println("\n List of products: \n ");
                JSONArray productList = jsonObject.getJSONArray("listJSon");
                for (int i = 0; i < productList.length(); i++) {
                    readJSONObject(productList.getJSONObject(i));
                    System.out.println("\n");
                }
            }
        } else {
            throw new IllegalArgumentException("Nothing to read!");


        }
    }

}
