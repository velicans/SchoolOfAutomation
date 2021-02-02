package day3exercises.test;

abstract class Plant implements Fructiferous, Eatable {
    protected final int oxygenProduction;
    protected String color;
    protected boolean eatable;
    protected int age;
    protected int height;
    protected String timeToHarvest;

    Plant(int oxygenProduction, int age, int height, boolean eatable, String timeToHarvest) {
        this.oxygenProduction = oxygenProduction;
        this.age = age;
        this.height = height;
        this.eatable = eatable;
    }

    Plant(int oxygenProduction) {
        this.oxygenProduction = oxygenProduction;
    }

    public abstract boolean isEatable();

    public int getOxygenProduction() {
        return oxygenProduction;
    }


}
