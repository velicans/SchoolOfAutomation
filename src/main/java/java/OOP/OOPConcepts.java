package OOP;

import Abstract.Dog;

public class OOPConcepts {

    public static void main(String[] args){

        /*OOP.Animal caine = new OOP.Dog("Rex");
        caine.makeSound();
        caine.makeSound2();

        OOP.Animal pisica = new OOP.Cat("Karma");
        pisica.makeSound();
        caine.makeSound2();

        OOP.Animal animal = new OOP.Animal();
        animal.makeSound();

        OOP.Animal animal2 = new OOP.Animal("rex");
        animal.makeSound2();

        OOP.Cat cat = new OOP.Cat("Karma");
        cat.makeSound();
        cat.makeSound("Another Sound");

        OOP.Dog caine = new OOP.Dog();
        caine.makeSound();*/

        Abstract.AnimalInterface pisica = new Abstract.Cat();
        //pisica.makesSound2();
        pisica.makesSound();

    }
}