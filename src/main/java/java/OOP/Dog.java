package OOP;

public class Dog extends Animal{

    String name;

    public Dog(String nume){
        super.name = nume;
        this.name = nume;
    }


    public void setName(String name){
        this.name = name;
        super.name = name;
    }

    public String getName(){
        return name;
    }

    public void makeSound(){
        System.out.println("Wof Wof Wof");
    }

    public void makeSoundDog(){
        System.out.println("Wof2 Wof2 Wof2");
    }
}