package json.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class JsonExample {


    public void readJSON(String filename) {
        Path fileLocation = Paths.get(System.getProperty("user.dir"), "Practice Files", filename + ".json");
        File file = new File(String.valueOf(fileLocation));
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) object;
            String productName = (String) jsonObject.get("product_name");
            System.out.println(productName);
            String supplier = (String) jsonObject.get("supplier");
            System.out.println(supplier);
            Long quantity = (Long) jsonObject.get("quantity");
            System.out.println(quantity);
            String unitCost = (String) jsonObject.get("unit_cost");
            System.out.println(unitCost);
        } catch (ParseException | IOException parseException) {
            parseException.printStackTrace();
        }
    }

    public void readJSONWithList(String filename) {
        Path fileLocation = Paths.get(System.getProperty("user.dir"), "Practice Files", filename + ".json");
        File file = new File(String.valueOf(fileLocation));
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) object;

            System.out.println("Product Name: " + jsonObject.get("product_name"));
            System.out.println("Supplier: " + jsonObject.get("supplier"));
            System.out.println("Quantity: " + jsonObject.get("quantity"));
            System.out.println("Unit Cost: " + jsonObject.get("unit_cost"));

            JSONArray products = (JSONArray) jsonObject.get("listJSon");
            Iterator iterator = products.iterator();
            System.out.println("\n List of Elements:");
            int counter = 0;
            while (iterator.hasNext()) {
                System.out.println("List index _______" + counter);
                JSONObject elementOfList = (JSONObject) iterator.next();
                System.out.println("Product Name: " + elementOfList.get("product_name"));
                System.out.println("Supplier: " + elementOfList.get("supplier"));
                System.out.println("Quantity: " + elementOfList.get("quantity"));
                System.out.println("Unit Cost: " + elementOfList.get("unit_cost"));
                counter++;
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }


}
