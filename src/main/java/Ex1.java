import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
//  1. Given n, a natural number, implement a method that for each number from 1 to n will return:
//	• 3M if the number is divided by 3
//	• 5M if the number is divided by 5
//	• the number if the number is not divided by 3 or by 5
//	• 3M5M if the number is divide with both 3 and 5

        Scanner sc = new Scanner(System.in);
        System.out.println("n: ");
        int n = sc.nextInt();
        System.out.println("n= " + n);

        for(int i=1; i <= n; i++) {
            if((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("3M5M: " + i);
            } else if(i % 3 == 0) {
                System.out.println("3M: " + i);
            } else if(i % 5 == 0) {
                System.out.println("5M: " + i);
            } else {
                System.out.println(i);
            }
        }
    }
}
