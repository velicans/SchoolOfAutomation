package Day3Exercises;

public class Rose extends Plant {

    private final int numberOfSpecies = 150;
    String type;
    String colour;

    public Rose(String colour, String type , int oxygenProduction) {
        super(oxygenProduction);
        this.colour = colour;
        this.type = type;
    }

    public int getNumberOfSpecies() {
        return numberOfSpecies;
    }

    public String getColour() {
        return colour;
    }

    public String getType() {
        return type;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Rose{" +
                "numberOfSpecies=" + numberOfSpecies +
                ", colour='" + colour + '\'' +
                ", type=" + type + '\'' +
                ", oxygenProduction=" + getOxygenProduction() +
                '}';
    }
}
