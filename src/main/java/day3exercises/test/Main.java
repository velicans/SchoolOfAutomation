package day3exercises.test;

public class Main {
    public static void main(String[] args) {

        Orange orange = new Orange(10, 5, true, "August", 50);

        System.out.println("Orange age : " + orange.getAge()
                + ", height : " + orange.getHeight()
                + ", eatable : " + orange.isEatable()
                + ", harvest : " + orange.getTimeToHarvest()
                + ", oxygen : " + orange.getOxygenProduction());

        Orange orange1 = new Orange(50);
        System.out.println("Orange age : " + orange1.getAge()
                + ", height : " + orange1.getHeight()
                + ", eatable : " + orange1.isEatable()
                + ", harvest : " + orange1.getTimeToHarvest()
                + ", oxygen : " + orange1.getOxygenProduction());

        Rose r = new Rose(50,2,10,"Red");
        System.out.println("Rose age : " + r.getAge()
                + ", height : " + r.getHeight()
                + ", eatable : " + r.isEatable()
                + ", harvest : " + r.getTimeToHarvest()
                + ", oxygen : " + r.getOxygenProduction());


    }
}
