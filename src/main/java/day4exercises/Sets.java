package day4exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Sets {
    public static void main(String[] args) throws FileNotFoundException {



        TreeSet<Persoane> persoane1 = new TreeSet<>(new PersoaneComparator());

        //System.out.println(e1.compareTo(e2));
        Path path = Paths.get(System.getProperty("user.dir"), "PracticeFiles", "names" + ".txt");
        File file = new File(String.valueOf(path));

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String temp = sc.nextLine();

            String [] t2 = temp.split(" ");

            persoane1.add(new Persoane(t2[0]+" "+t2[1],Integer.parseInt(t2[2])));

        }

        Persoane o = new Persoane("Liam Olivia",22);




        for (Persoane p : persoane1){
            System.out.println(p);
            System.out.println(p.equals(o));
        }
        System.out.println("------------------------------------------------------------");


        Map<Persoane, List<Hobby>> hobbies = new HashMap<>();


        for (Persoane p : persoane1){
            List<Hobby> hobby= new ArrayList<>();
            List<Adresa> adresas = new ArrayList<>();

            adresas.add(new Adresa("Brasov","Carpatilor",10));

            hobby.add(new Hobby("Sports",3,adresas));
            hobbies.put(p,hobby);
        }


        hobbies.forEach((k,v) -> System.out.println(k+" "+v));

    }
}
