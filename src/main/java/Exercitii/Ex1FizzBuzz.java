package Exercitii;

// 1. Given n, a natural number, implement a method that for each number from 1 to n will return:
//           • 3M if the number is divided by 3
//           • 5M if the number is divided by 5
//           • the number if the number is not divided by 3 or by 5
//           • 3M5M if the number is divide with both 3 and 5

public class Ex1FizzBuzz {

    public void Ex1FizzBuzz(int numberOfIterations) {

        for (int i = 1; i <= numberOfIterations; i++)
        {
            if (i % 5 == 0 && i % 3 == 0)
                System.out.print("FizzBuzz"+" ");
            else if (i % 5 == 0)
                System.out.print("Buzz"+" ");
            else if (i % 3==0)
                System.out.print("Fizz"+" ");
            else
                System.out.print(i+" ");
        }
        System.out.println("");
    }
}
