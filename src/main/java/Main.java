import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//  4. Write a method that iterates through a list of Strings and makes them lowercase

        ArrayList<String> list = new ArrayList<String>();
        list.add("ciocolata");
        list.add("NUTELLA");
        list.add("finetTi");

        System.out.println("List before lowercase: \n" + list);
        lowercaseList(list);
        System.out.println("List after lowercase: \n" + list);
    }

    public static ArrayList<String> lowercaseList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toLowerCase());
        }
        return list;
    }
}