package oop.plants;

public class Pinidae extends Plant {
    private Integer numberOfSpecies;

    public Pinidae(Integer oxygenProduction) {
        super(oxygenProduction);
        this.numberOfSpecies = 50;
    }

    public Integer getNumberOfSpecies() {
        return numberOfSpecies;
    }

    public void setNumberOfSpecies(Integer numberOfSpecies) {
        this.numberOfSpecies = numberOfSpecies;
    }

    public String getGrowthEnvironment() {
        return "mountain";
    }
}
