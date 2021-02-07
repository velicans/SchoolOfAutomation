package Tema1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Tema1 {


    //1. Given n, a natural number, implement a method that for each number from 1 to n will return:
//            • 3M if the number is divided by 3
//            • 5M if the number is divided by 5
//            • the number if the number is not divided by 3 or by 5
//            • 3M5M if the number is divide with both 3 and 5
    static void diviz (int N){
        for(int i = 1; i < N; i++){
            if (i % 3 ==0){
                if (i % 5 == 0){
                    System.out.println("3M5M");
                } else{
                    System.out.println("3M");
                }
            }else if (i % 5 == 0){
                System.out.println("5M");
            }else {
                System.out.println(i);
            }
        }
    }

    //2. Write three functions that compute the sum of the numbers in a list: using a for-loop, a for-each-loop and a while-loop
    static int sum1 (int [] listNum)
    {   int sum = 0;
        for(int i = 0;i< listNum.length; i++){
            sum = sum + listNum[i];
        }
        return sum;
    }

    static int sum2 (int [] listNum)
    {
        int sum = 0;
        for( int num : listNum){
            sum = sum + num;
        }
        return sum;
    }

    static int sum3 (int  [] listNum)
    {
        int sum = 0;
        int i = 0;
        while (i < listNum.length){
            sum = sum + listNum[i];
            i++;
        }
        return sum;
    }

    //3. Write a method that prints the next 20 leap years.
    static void leapYear () {
        int [] listaLeapYear = new int[20];
        for (int i = 0; i < 20 ; i++) {
            listaLeapYear[i] = 2024 + i*4;
            System.out.println(listaLeapYear[i]);
        }
    }

    // 4. Write a method that iterates through a list of Strings and makes them lowercase
    static void lowerCaseString (){
        List<String> list = new ArrayList<String>();
        list.add("Cineva");
        list.add("Oras");
        list.add("LAMAIE");
        list.add("CAlendar");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).toLowerCase());
        }
    }

    // 5. Write a method that iterates through an array or list of numbers and replaces the current number with it’s double.
    static void dublu (int [] numere){
        System.out.println("Dublul sirului este:");
        for (int i = 0; i < numere.length; i++){
            numere[i] = 2* numere[i];
            System.out.println(numere[i]);
        }

    }


    public static void main(String[] args){

        System.out.println("Hello world!");

        int n = 16;
        diviz(n);

        int[] listaNum = {5, 7, 12, 23};
        System.out.println("Prima metoda de calcul: " + sum1(listaNum));
        System.out.println("A doua metoda de calcul: " + sum2(listaNum));
        System.out.println("A treia metoda de calcul: " + sum3(listaNum));

        System.out.println("Urmatorii 20 de ani bisecti sunt: ");
        leapYear();
        lowerCaseString ();
        dublu(listaNum);


    }

}
