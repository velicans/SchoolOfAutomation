package Day3Exercises;

public class Pinidae extends  Plant {

    public int numberOfSpecies = 50;

    public void setNumberOfSpecies(int numberOfSpecies) {
        this.numberOfSpecies = numberOfSpecies;
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
