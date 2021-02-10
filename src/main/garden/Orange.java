package garden;

public class Orange extends Plant implements Fructiferous, Eatable{
    String timeToHarvest;
    int age;
    int height;
    boolean eatable;

    public Orange(){

    }

    public Orange(int age, int height, boolean eatable, String timeToHarvest, int oxygenProduction ){
        this.age = age;
        this.height = height;
        this.eatable = eatable;
        this.timeToHarvest = timeToHarvest;
        this.oxygenProduction = oxygenProduction;
    }

    public String getTimeToHarvest(){
        return timeToHarvest;
    }

    public boolean isEatable(){
        return eatable;
    }


}
