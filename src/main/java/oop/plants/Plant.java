package oop.plants;

public abstract class Plant {
    private final Integer oxygenProduction;

    public Plant(Integer oxygenProduction) {
        this.oxygenProduction = oxygenProduction;
    }

    public Integer getOxygenProduction() {
        return oxygenProduction;
    }


}
