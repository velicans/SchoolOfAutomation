package day3exercises.main;

public class Cedar extends Pinidae implements Eatable {


    Cedar(int oxygen) {
        super(oxygen);
        super.numberOfSpecies = 10;
    }

    public String getGrowthEnvironment() {
        return (super.getGrowthEnvironment() + " and Mediterranean");
    }


    @Override
    public boolean isEatable() {
        return false;
    }
}
