package fileHandling;


import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;

public class FilesHandling {
    public static void main(String[] args) {
        //fileReaderIo("Animals");
       // System.out.println(jsonReader("JsonExample"));
        System.out.println(jsonReaderWithList("JsonWithListOfJsons"));
    }

    public static JSONObject jsonReader(String fileName) {
        JSONParser parser = new JSONParser();
        try{
            String textLocation = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")
                    ,"PracticeFiles",fileName + ".json")), StandardCharsets.UTF_8);

            JSONObject obj = new JSONObject(textLocation);

            String productName = obj.getString("product_name");
            String supplier = obj.getString("supplier");
            String cost = obj.getString("unit_cost");
            int quantity = obj.getInt("quantity");

           //System.out.println(productName + " " + supplier + " " + cost + " " + quantity);

           return obj;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject jsonReaderWithList(String fileName) {
        JSONParser parser = new JSONParser();
        try{
            String textLocation = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")
                    ,"PracticeFiles",fileName + ".json")), StandardCharsets.UTF_8);

            JSONObject obj = new JSONObject(textLocation);

            String productName = obj.getString("product_name");
            String supplier = obj.getString("supplier");
            String cost = obj.getString("unit_cost");
            int quantity = obj.getInt("quantity");
            JSONArray arr = obj.getJSONArray("listJSon");

            for(int i = 0; i < arr.length(); i++) {
                String productName2 = obj.getString("product_name");
                String supplier2 = obj.getString("supplier");
                String cost2 = obj.getString("unit_cost");
                int quantity2 = obj.getInt("quantity");

                //System.out.println(productName2 + " " + supplier2 + " " + cost2 + " " + quantity2);
            }

            //System.out.println(productName + " " + supplier + " " + cost + " " + quantity);

            return obj;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void fileReaderIo(String fileName) {
       Path textLocation = Paths.get(System.getProperty("user.dir"),"PracticeFiles",fileName + ".txt");
       File file = new File(String.valueOf(textLocation));

       try{
           List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
           for(String animal : lines) {
               System.out.println(animal);
           }
       } catch(IOException e) {
           System.out.println("Catch something");
       }
    }

}


