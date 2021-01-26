import java.util.ArrayList;

public class Ex2 {
// 2. Write three functions that compute the sum of the numbers in a list: using a for-loop,
// a for-each-loop and a while-loop

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(20);

        System.out.println(sumUsingForLoop(list));
        System.out.println(sumUsingForeachLoop(list));
        System.out.println(sumUsingWhileLoop(list));

    }

    public static int sumUsingForLoop(ArrayList<Integer> list) {
        int sum = 0;
        for(int i=0; i< list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static int sumUsingForeachLoop(ArrayList<Integer> list) {
        int sum = 0;
        for(int item : list) {
            sum += item;
        }
        return sum;
    }

    public static int sumUsingWhileLoop(ArrayList<Integer> list) {
        int sum = 0;
        int count = 0;
        while(list.size() > count) {
            sum += list.get(count);
            count++;
        }
        return sum;
    }

}
