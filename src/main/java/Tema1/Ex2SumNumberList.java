package Examples.Tema1;

import java.util.ArrayList;
import java.util.List;

public class Ex2SumNumberList {

    static void forLoop() {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(10);
        list.add(9);

             for (int i = 0; i < list.size(); i++) {
                 sum += list.get(i);}
             System.out.println("sum for-loop " + sum);
         }

    static void forEachLoop() {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(10);
        list.add(9);

        for (Integer listItem: list) {
            sum += listItem;}
        System.out.println("sum for-each-loop " + sum);}

    static void whileLoop() {
        int sum = 0;
        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        list.add(6);
        list.add(10);
        list.add(9);

        while (list.size() > count) {
            sum += list.get(count);
            count++; }
        System.out.println("sum while-loop " + sum);}

    public static void main(String[] args) {
        forLoop();
        forEachLoop();
        whileLoop();
    }
}
