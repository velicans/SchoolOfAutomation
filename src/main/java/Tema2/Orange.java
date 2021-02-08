package Tema2;

public class Orange extends Plant implements Fructiferous, Eatable {
    int age;
    int height;

    int oxygenProduction = 50;
    String color = "orange";
    public void getTimeToHarvest (){
        System.out.println("August");
    }
    public boolean isEatable(){
        System.out.println("Oranges are eatable");
        return true;
    }
    public Orange(int varsta, int inaltime){
        age = varsta;
        height = inaltime;
    }

}
