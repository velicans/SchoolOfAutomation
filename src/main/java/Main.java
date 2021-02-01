package Tema2;

public class Main {
    public static void main(String[] args){

 Orange orangeTree = new Orange();
 orangeTree.age = 10;
 orangeTree.height = 5;
 Boolean eatable = orangeTree.isEatable();
 orangeTree.oxygenProduction = 50;
 String timeToHarvest = orangeTree.getTimeToHarvest();

 System.out.println("Orange tree age " + orangeTree.age);
 System.out.println("Orange tree height " + orangeTree.height);
 System.out.println("Orange tree oqygen production " + orangeTree.oxygenProduction);
 System.out.println("Time to harvest " + timeToHarvest);
 System.out.println("Is eatable " + eatable);

 Pinidae cedarTree = new Pinidae();
 cedarTree.oxygenProduction = 200;
 cedarTree.numberOfSpecies = 10;
 String getEnv = cedarTree.getGrowthEnvironment();
 System.out.println("Piniade: Number of species " + cedarTree.numberOfSpecies);
 System.out.println("Piniade: Environment " + getEnv);

 Rose sweety = new Rose();
 sweety.name = "RedSweety";
 sweety.haveColor();
    }
}