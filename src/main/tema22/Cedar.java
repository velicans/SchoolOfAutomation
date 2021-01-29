public class Cedar extends Pinidae implements Eatable{

    int numberOfSpecies = 10;
    @Override
    public String getGrowthEnvironment(){
        return "mountain and Mediterranean";

}

    public int getNumberOfSpecies() {
        return numberOfSpecies;

    }

    public void setNumberOfSpecies(int numberOfSpecies) {
        this.numberOfSpecies = numberOfSpecies;
    }

    public boolean isEatable(){

        return false;

    }

    @Override
    public void Oxygen(int oxygenProduction) {

    }
}
