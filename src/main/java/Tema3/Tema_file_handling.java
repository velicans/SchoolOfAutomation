package Tema3;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tema_file_handling {
    public static void main(String[] args){
        jsonReaderIO("JsonExample");
    }

    public static void jsonReaderIO(String filename) {

        Path textLocation = Paths.get(System.getProperty("user.dir"), "PracticeFiles", filename + ".json");
        File file = new File(String.valueOf(textLocation));

        try{
            String content= FileUtils.readFileToString(file,"UTF-8");
            JSONObject jsonObject=new JSONObject(content);
            String field1 = jsonObject.getString("product_name");
            String field2 = jsonObject.getString("supplier");
            int field3 = jsonObject.getInt("quantity");
            String field4 = jsonObject.getString("unit_cost");
            System.out.println(field1 +" "+ field2 + " " + field3 +" " + field4);

        }catch (IOException e){
            System.out.println("Catched something");
        }
    }

    public static void fileReaderIO(String filename) {
        Path textLocation = Paths.get(System.getProperty("user.dir"), "PracticeFiles", filename + ".txt");
        File file = new File(String.valueOf(textLocation));

        try {
            List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);

            for(String animals: lines) {
                System.out.println(animals);
            }
        } catch (IOException e){
            System.out.println("Catched something");
        }
    }

    public static void fileReader(){
        try {
            ArrayList<String> lines = new ArrayList<>();

            Path dir = Paths.get("").toAbsolutePath();

            File myObj = new File(dir + "\\PracticeFiles\\Animals.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }

            for(String animals: lines){
                System.out.println(animals);
            }

            lines.forEach(System.out::println);

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
