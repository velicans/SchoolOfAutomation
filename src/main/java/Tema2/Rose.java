package Tema2;

public class Rose extends Plant implements Eatable{

    String color;

    public boolean isEatable(){
        System.out.println("Roses are not eatable");
        return false;
    }

    public Rose(String culoare){
        color = culoare;
    }
}
