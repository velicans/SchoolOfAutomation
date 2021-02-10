package FileHandling;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FilesHandling {

    public static void main(String[] args){
     /*   String[] cars = {"Volvo", "BMW", "Mazda", "Ford"};

        String[] carz = new String[4];
        carz[0] = "Volvo";
        carz[1] = "BMW";

        String[][] array = {{"BMW", "Volvo", "Mazda"}, {"Usa", "Luneta", "Roata"}, {}};

        //System.out.println(array[1][0]);

        ArrayList<String> carsArrayList = new ArrayList<String>();
        carsArrayList.add("BMW");
        carsArrayList.add("Volvo");
        carsArrayList.add("Mazda");
        carsArrayList.add("Ford");

        carsArrayList.set(1, "Volvorescris");

        carsArrayList.remove(2);

        System.out.println(carsArrayList.get(1));

        System.out.println(carsArrayList.size());

        for(int i = 0; i < carsArrayList.size(); i++)
            System.out.println(carsArrayList.get(i));

        for(String car:carsArrayList)
            System.out.println(car);

        HashMap<String, ArrayList<String>> hashMapExample = new HashMap<String, ArrayList<String>>();

        hashMapExample.put("BMW", carsArrayList);
        hashMapExample.put("Ford", carsArrayList);
        hashMapExample.put("Mazda", carsArrayList);

        System.out.println(hashMapExample.get("BMW"));

        System.out.println("-----------------------------------------------------------------------------------------------------");

        for(String cheie: hashMapExample.keySet())
            System.out.println("Key: " + cheie + " Value: " + hashMapExample.get(cheie));


        carsArrayList.clear();

        fileReader();*/

        //fileReaderIO("Animals");

        // System.out.println()     Cheie:    Valoare:

    }

    public static JSONObject jsonReaderIO(String filename) {
        //filereader
        //parsam JSON file
        //returnam JSON Object
        return null; //obiect JSON
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
