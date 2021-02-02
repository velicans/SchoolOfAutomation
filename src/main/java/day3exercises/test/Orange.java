package day3exercises.test;

public class Orange extends Plant implements Fructiferous,Eatable {


    protected int age;
    protected int height;
    protected String timeToHarvest;



    Orange(int age, int height, boolean eatable, String timeToHarvest, int oxygenProduction){
        super(oxygenProduction);
        this.age=age;
        this.height=height;
        this.eatable=eatable;
        this.timeToHarvest=timeToHarvest;

    }

    Orange(int oxygenProduction){
        super(oxygenProduction);
    }

    public boolean isEatable(){
        return true;
    }

    public void setColor(String color) {
        this.color=color;
    }

    public String getColor() {
        return this.color;
    }

    public String getTimeToHarvest(){
        return timeToHarvest;
    }

    public void setTimeToHarvest(String timeToHarvest) {
        this.timeToHarvest = timeToHarvest;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
