package Examples.Tema1;

import java.util.Scanner;

public class Ex1{
    public static void main(String[] args) {
        int n;
        System.out.println("numarul n = ");
        n = new Scanner(System.in).nextInt();

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



