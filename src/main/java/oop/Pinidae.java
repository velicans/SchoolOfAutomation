package oop;

public class Pinidae extends Plant{

    public int numberOfSpecies = 50;

    public Pinidae(double oxygenProduction) {
        super(oxygenProduction);
        this.numberOfSpecies = 50;
    }

    public String getGrowthEnvironment() {
        return "mountain";
    }
}
