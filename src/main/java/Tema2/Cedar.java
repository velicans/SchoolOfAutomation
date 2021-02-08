package Tema2;

public class Cedar extends Pinidae implements Eatable{
    public  int numberOfSpecies =10;

    @Override
    String getGrowthEnvironment (){
        return "mountain" +" "+"Mediterranean";
    }

    public boolean isEatable(){
        System.out.println("Cedars are not eatable");
        return false;
    }

    public Cedar(int oxygenProd){
        oxygenProduction = oxygenProd;
    }

}
