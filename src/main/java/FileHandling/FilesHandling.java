package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesHandling {

    public static void main(String[] args){
        fileReader();
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
