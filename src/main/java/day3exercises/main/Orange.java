package day3exercises.main;

public class Orange extends Plant implements Fructiferous, Eatable {
    int age;
    int height;
    boolean eatable;
    String harvest;

    Orange(int oxygenProduction) {
        super(oxygenProduction);
    }

    Orange(int age, int height, boolean eatable, String harvest, int oxygen) {
        super(oxygen);
        this.age = age;
        this.height = height;
        this.eatable = eatable;
        this.harvest = harvest;
    }


    @Override
    public String getTimeToHarvest() {
        return harvest;
    }

    @Override
    public boolean isEatable() {
        return eatable;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
