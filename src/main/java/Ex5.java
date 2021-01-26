import java.util.ArrayList;

public class Ex5 {

    public static void main(String[] args) {
// 5. Write a method that iterates through an array or list of numbers and replaces the current number
// with it’s double.

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(20);

        System.out.println("List before update: \n" + list);
        doubleList(list);
        System.out.println("List after update: \n" + list);
    }

    public static ArrayList<Integer> doubleList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) * 2);
        }
        return list;
    }
}
