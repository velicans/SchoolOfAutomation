package day3exercises.test;

public class Pinidae extends Plant {

    protected int numberOfSpecies=50;

    Pinidae(int oxygenProduction){
        super(oxygenProduction);
        eatable=false;
    }

    public boolean isEatable(){
        return eatable;
    }

    public String getGrowthEnvironment(){
        return "Mountain";
    }

    @Override
    public void setColor(String color) {
        this.color="Green";
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getTimeToHarvest() {
        return null;
    }
}
