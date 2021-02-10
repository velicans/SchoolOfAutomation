package garden;

public class Main {
    public static void main(String[] args) {

        Orange orange = new Orange(10,5,true,"August",50);
        Orange orange2 = new Orange(7,57,false,"ffff",555);


        Pinidae p1 = new Cedar();
        System.out.println(p1.numberOfSpecies);
        System.out.println(p1.getGrowthEnvironment());
        Pinidae p2 = new Pinidae();
        Cedar c1 = new Cedar();


        Rose r1 = new Rose("yellow");
        System.out.println();
;    }
}
