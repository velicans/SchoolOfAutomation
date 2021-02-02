package oop;

public class Pinidae extends Plant{

    private double oxygenProduction;
    public int numberOfSpecies = 50;

    public Pinidae(double oxygenProduction) {
        this.oxygenProduction = oxygenProduction;
        this.numberOfSpecies = 50;
    }

    public String getGrowthEnvironment() {
        return "mountain";
    }
}
