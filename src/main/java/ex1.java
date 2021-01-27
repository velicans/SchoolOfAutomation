public class ex1 {

    public static void verifyDivision(int n) {

    System.out.println("verfificare pentru n =" + n);
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.println("3M5M");
            } else if (i % 5 == 0) {
                System.out.println("5M");
            } else if (i % 3 == 0) {
                System.out.println("3M");
            } else {
                System.out.println(i);

            }
        }
    }

    public static void main(String[] args){
        System.out.println("Hello world!");
        verifyDivision(16);


    }

}