package oop.plants;

public class Cedar extends Pinidae implements Eatable {

    public Cedar(Integer oxygenProduction) {
        super(oxygenProduction);
        this.setNumberOfSpecies(10);
    }

    @Override
    public String getGrowthEnvironment() {
        return "mountain and Mediterranean";
    }

    @Override
    public boolean isEatable() {
        return false;
    }

    @Override
    public String toString() {
        return "Cedar{" +
                "numberOfSpecies=" + getNumberOfSpecies() +
                ", oxygenProduction=" + getOxygenProduction() +
                ", isEatable= " + isEatable() +
                '}';
    }
}
