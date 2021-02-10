package Abstract;

public class Cat implements AnimalInterface {

    public void makesSound() {
        System.out.println("Meow");
    }

    public int howManyLegs(){
        return 4;
    }

    public boolean isAlive(){
        return true;
    }

    public String animalName(String name){
        return name + " pisica";
    }

    public void makesSound2(){
        System.out.println("Meow Meow Meow");
    }

}
