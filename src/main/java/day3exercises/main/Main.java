package day3exercises.main;

public class Main {
    public static void main(String[] args) {
        Orange o = new Orange(10, 5, true, "August", 50);
        System.out.println("Time to harvest : " + o.getTimeToHarvest()
                + " Oxygen production : " + o.getOxygenProduction() + "\n");


        Cedar c = new Cedar(200);
        System.out.println("Cedar number of species : " + c.numberOfSpecies
                + " Oxygen production : " + c.oxygenProduction
                + " Growth environment : " + c.getGrowthEnvironment());

        Pinidae p = new Pinidae(150);
        System.out.println("Pinidae number of species : " + p.numberOfSpecies
                + " Oxygen production : " + p.oxygenProduction
                + " Growth environment : " + p.getGrowthEnvironment());


    }
}
