package Day3Exercises;

public class Orange extends Plant implements Fructiferous, Eatable {

    private int age;
    private int height;

    public Orange() {
    }

    public Orange(int age, int height, int oxygenProduction) {
        this.age = age;
        this.height = height;
        setOxygenProduction(oxygenProduction);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
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
                ", isEatable=" + isEatable() +
                ", timeToHarvest=" + getTimeToHarvest() +
                ", oxygenProduction=" + getOxygenProduction() +
                '}';
    }
}
