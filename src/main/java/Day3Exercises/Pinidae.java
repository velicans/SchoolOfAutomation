package Day3Exercises;

public class Pinidae extends  Plant {

    private final int numberOfSpecies = 50;

    public Pinidae(int oxygenProduction) {
        super(oxygenProduction);
    }

    public int getNumberOfSpecies() {
        return numberOfSpecies;
    }

    public String getGrowthEnvironment() {
        return "Mountain";
    }

    @Override
    public String toString() {
        return "Pinidae{" +
                "numberOfSpecies=" + numberOfSpecies +
                ", oxygenProduction=" + getOxygenProduction() +
                ", growthEnvironment=" + getGrowthEnvironment() +
                '}';
    }
}
