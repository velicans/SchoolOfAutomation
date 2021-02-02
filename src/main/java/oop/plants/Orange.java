package oop.plants;

public class Orange extends Plant implements Fructiferous, Eatable {

    private Integer age;
    private Double height;

    public Orange(Integer oxygenProduction, Integer age, Double height) {
        super(oxygenProduction);
        this.age = age;
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String getTimeToHarvest() {
        return "August";
    }

    @Override
    public boolean isEatable() {
        return true;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "age=" + age +
                ", height=" + height +
                ", oxygenProduction=" + getOxygenProduction() +
                ", isEatable= " + isEatable() +
                ", timeToHarvest= " + getTimeToHarvest() +
                '}';
    }
}
