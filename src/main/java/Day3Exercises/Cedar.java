package Day3Exercises;

public class Cedar extends Pinidae implements Eatable {

    private final int numberOfSpecies = 10;

    public Cedar(int oxygenProduction) {
        setOxygenProduction(oxygenProduction);
    }

    public String getGrowthEnvironment() {
        return super.getGrowthEnvironment() + " and Mediterranean";
    }

    @Override
    public boolean isEatable() {
        return false;
    }

    @Override
    public String toString() {
        return "Cedar{" +
                "oxygenProduction=" + getOxygenProduction() +
                ", isEatable=" + isEatable() +
                ", numberOfSpecies=" + numberOfSpecies +
                ", growthEnvironment=" + getGrowthEnvironment() +
                '}';
    }
}
