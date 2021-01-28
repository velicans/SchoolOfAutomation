import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Ex. 1
        int i;
        int n = 17;
        ArrayList<Pair> listOfPairs;
        listOfPairs = checkDiv3or5(n);

        for (i = 0; i < n; i++) {
            System.out.println(listOfPairs.get(i).getMyNumber() + " - " +
                    listOfPairs.get(i).getMyValue());

        }
    }


    /*
     * Given n, a natural number, the method will return for each number
     * from 1 to n:
     *      3M if the number is divided by 3
     *      5M if the number is divided by 5
     *      the number if the number is not divided by 3 or by 5
     *      3M5M if the number is divide with both 3 and 5
     */
    public static ArrayList<Pair> checkDiv3or5(int n) {

        int i;
        ArrayList<Pair> listOfPairs = new ArrayList<>(n);

        for (i = 1; i <= n; i++) {

            if (i % 3 == 0) {

                if (i % 5 == 0) {
                    listOfPairs.add(new Pair(i, "3M5M"));
                } else {
                    listOfPairs.add(new Pair(i, "3M"));
                }
            } else if (i % 5 == 0) {
                listOfPairs.add(new Pair(i, "5M"));
            } else {
                listOfPairs.add(new Pair(i, String.valueOf(i)));
            }
        }
        return listOfPairs;
    }
}