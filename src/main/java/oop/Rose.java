package oop;

public class Rose extends Plant implements Eatable, Fructiferous{
    private String color;
    private double age;
    private double height;

    public Rose(double oxygenProduction, String color, double age, double height) {
        super(oxygenProduction);
        this.color = color;
        this.age = age;
        this.height = height;
    }

    public String getTimeToHarvest() {
        return "May";
    }

    @Override
    public String toString() {
        return "Rose: " +
                "oxygenProduction: " + oxygenProduction +
                ", color: " + color +
                ", age: " + age +
                ", height: " + height;
    }

    public boolean isEatable() {
        return false;
    }
}
