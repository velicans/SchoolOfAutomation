package Exercitii;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){

        Ex1FizzBuzz obj1 = new Ex1FizzBuzz();
        obj1.Ex1FizzBuzz(20);

        Ex2Sum obj2 = new Ex2Sum();
        obj2.ForLoopSum(5);
        obj2.ForEachSum(5);
        obj2.WhileLoopSum(5);

        Ex3LeapYear obj3 = new Ex3LeapYear();
        obj3.getLeapYears(2000);

        Ex4LowerCase obj4 = new Ex4LowerCase();
        List<String> myList = Arrays.asList("UPPERCASE", "UpPPERCASE", "UpPpERcAsE");
        obj4.CastListToLowerCase(myList);

        Ex5DoubleReplacement obj5 = new Ex5DoubleReplacement();
        obj5.ReplaceNumberWithDouble(5);

        }

    }


