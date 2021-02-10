package garden;
public class Pinidae extends Plant{
    int numberOfSpecies = 50;
    String growthEnvironment = "mountain";

    public String getGrowthEnvironment(){
        return growthEnvironment;
    }

    public void setGrowthEnvironment(String growthEnvironment) {
        this.growthEnvironment = growthEnvironment;
    }
}
