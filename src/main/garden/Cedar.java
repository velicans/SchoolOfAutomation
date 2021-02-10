package garden;

public class Cedar extends Pinidae implements Eatable {

    public int numberOfSpecies = 10;
    String growthEnvironment = "mountain and Mediterranean";

    public String getGrowthEnvironment(){
        return growthEnvironment;
    }
    public boolean isEatable(){
        return false;
    }
}
