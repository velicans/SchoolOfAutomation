package oop.plants;

public class Rose extends Plant {

    private Integer numberOfFlowers;

    public Rose(Integer oxygenProduction, Integer numberOfFlowers) {
        super(oxygenProduction);
        this.numberOfFlowers = numberOfFlowers;
    }

    public Integer getNumberOfFlowers() {
        return numberOfFlowers;
    }

    public void setNumberOfFlowers(Integer numberOfFlowers) {
        this.numberOfFlowers = numberOfFlowers;
    }

    @Override
    public String toString() {
        return "Rose{" +
                "oxygenProduction=" + getOxygenProduction() +
                ", numberOfFlowers=" + numberOfFlowers +
                '}';
    }
}
