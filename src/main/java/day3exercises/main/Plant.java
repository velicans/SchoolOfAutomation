package day3exercises.main;

public abstract class Plant {
    int oxygenProduction;

    Plant(int oxygenProduction) {
        this.oxygenProduction = oxygenProduction;
    }

    protected int getOxygenProduction() {
        return oxygenProduction;
    }
}
