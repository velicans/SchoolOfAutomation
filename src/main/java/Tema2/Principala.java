package Tema2;

public class Principala {

        public static void main(String[] args){
                Orange Portocala = new Orange(10, 5);
                Pinidae copac = new Cedar(200);

                System.out.println("The number of species of the cedars are:" +copac.numberOfSpecies);
                System.out.println("Growth Environment for cedars is:" +copac.getGrowthEnvironment());

                Rose transafir = new Rose("Red");
                transafir.isEatable();
        }
}
