package Examples.Tema1;

public class Ex1DivideNumber {
    public static void main(String[] args) {
        int n = 16;

        for (int i = 1; i < n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("3M5M");
            } else {
                if (i % 3 == 0) {
                    System.out.println("3M");
                } else {
                    if (i % 5 == 0) {
                        System.out.println("5M");
                    } else {
                        if ((i % 3 != 0) || (i % 5 != 0)) {
                            System.out.println(i);
                        }
                    }
                }
            }
        }
    }
}
