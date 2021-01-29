public class Main {


    public static void main(String[] args) {

        //g) Create an object: An orange tree, aged 10, of height 5, that is eatable, the time to harvest is August and an oxygen production of 50
        Orange tree = new Orange();
        tree.setAge(10);
        tree.setHeight(5);
        tree.isEatable();
        tree.getTimeToHarvest();
        tree.setOxygenProduction(50);


        //h) Create an object: A Cedar tree having a reference type of Pinidae, with an oxygen production of 200, not eatable.
        // Print the field number of species and the result of the getGrowthEnvironment method.
        Pinidae tree2 = new Cedar();
        tree2.setOxygenProduction(200);
        ((Cedar) tree2).isEatable();
        System.out.println(((Cedar) tree2).getNumberOfSpecies());
        System.out.println(tree2.getGrowthEnvironment());



        //i) Implement a way to create a Rose object
        Flower Rose = new Flower();



    }




}


