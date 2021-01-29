public class Orange extends Plant implements Fructiferous, Eatable {

    int age;
    double height;

    @Override
    public String getTimeToHarvest() {

        return "August";

    }

    public void setOxygenProduction(int oxygenProduction) {
        this.oxygenProduction = oxygenProduction;
    }

    public void Oxygen(int oxygenProduction) {

    }


   public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

        @Override
    public boolean isEatable() {

        return true;

    }

}
