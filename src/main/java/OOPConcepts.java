import Abstract.Dog;

public class OOPConcepts {

    public static void main(String[] args){

        /*Animal caine = new Dog("Rex");
        caine.makeSound();
        caine.makeSound2();

        Animal pisica = new Cat("Karma");
        pisica.makeSound();
        caine.makeSound2();

        Animal animal = new Animal();
        animal.makeSound();

        Animal animal2 = new Animal("rex");
        animal.makeSound2();

        Cat cat = new Cat("Karma");
        cat.makeSound();
        cat.makeSound("Another Sound");

        Dog caine = new Dog();
        caine.makeSound();*/

        Abstract.AnimalInterface pisica = new Abstract.Cat();
        //pisica.makesSound2();
        pisica.makesSound();

    }
}