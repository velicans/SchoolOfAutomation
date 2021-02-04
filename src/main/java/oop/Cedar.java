package oop;

public class Cedar extends Pinidae implements Eatable{
    private double oxygenProduction;
    public int numberOfSpecies;

    public Cedar(double oxygenProduction) {
        super(oxygenProduction);
        super.numberOfSpecies = 10;
    }

    public String getGrowthEnvironment() {
        return "mountain and Mediterranean";
    }

    public boolean isEatable() {
        return false;
    }
}
