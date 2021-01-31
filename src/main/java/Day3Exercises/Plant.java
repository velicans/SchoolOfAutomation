package Day3Exercises;

public abstract class Plant {

    private int oxygenProduction;

    public Plant(int oxygenProduction) {
        this.oxygenProduction = oxygenProduction;
    }

    public void setOxygenProduction(int oxygenProduction) {
        this.oxygenProduction = oxygenProduction;
    }

    public int getOxygenProduction() {
        return oxygenProduction;
    }
}
