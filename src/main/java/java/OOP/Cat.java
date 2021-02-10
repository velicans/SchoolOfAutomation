package OOP;

public class Cat extends Animal {

    public Cat(String nume){
        super(nume);
    }

    public void makeSound(){
        System.out.println("Meow");
    }

    public void makeSound(String anotherSound){
        System.out.println(anotherSound);
    }

}
