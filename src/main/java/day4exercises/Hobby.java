package day4exercises;

import java.util.List;

public class Hobby {
    String hobbyName;
    int frequency;
    List<Adresa> adresa;

    Hobby(String hobbyName, int frequency, List<Adresa> adresa){
        this.hobbyName = hobbyName;
        this.frequency=frequency;
        this.adresa=adresa;
    }

    @Override
    public String toString() {
        return "Hobby: "+hobbyName+" Frequency: "+frequency+" Adress: "+adresa;
    }
}
