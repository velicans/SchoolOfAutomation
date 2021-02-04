package oop;

public class Main {
    public static void main(String[] args) {
        Orange orangeTree = new Orange(50,"orange",10,5);
        System.out.println(orangeTree);
        System.out.println(orangeTree.isEatable());
        System.out.println(orangeTree.getTimeToHarvest());

        Pinidae cedarTree = new Cedar(200);
        System.out.println(cedarTree.numberOfSpecies);
        System.out.println(cedarTree.getGrowthEnvironment());

        Rose rose = new Rose(30,"red",1,3);
        System.out.println(rose);
    }
}
