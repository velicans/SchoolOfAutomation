package oop;

public class Orange extends Plant implements Fructiferous, Eatable{
    private String color;
    private double age;
    private double height;

    public Orange(double oxygenProduction, String color, double age, double height) {
        super(oxygenProduction);
        this.color = color;
        this.age = age;
        this.height = height;
    }

    public String getTimeToHarvest() {
        return "August";
    }

    public boolean isEatable() {
        return true;
    }

    @Override
    public String toString() {
        return "Orange: " +
                "oxygenProduction: " + oxygenProduction +
                ", color: " + color +
                ", age: " + age +
                ", height: " + height;
    }
}
