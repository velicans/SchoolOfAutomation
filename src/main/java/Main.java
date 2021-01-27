import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class Main {

    public static void main(String[] args){
          List<Integer> numberList = new ArrayList<>();
          numberList.add(1);
          numberList.add(7);
          numberList.add(2);
          int sum = 0;
       //for (int a = 0; a < numberList.size(); a++)
          for (int a = 0; a < 3; a++)
              sum = sum + numberList.get(a);

          System.out.println("1.suma numerelor este " + sum);

        Main.afisSuma(numberList);

        List<String> lObject = Main.creazaLista();
        Main.afiseazaUpperCase(lObject);

    }

    public static void afisSuma(List<Integer> lista)
    {
        int sum = 0;
        for (Integer b : lista)
            sum = sum + b;
        System.out.println("2.suma numerelor este" + sum);
    }

    public static List<String> creazaLista() {
        List<String> numberList = new ArrayList<>();
        numberList.add("a");
        numberList.add("b");
        numberList.add("c");
        return numberList;
    }

    public static void afiseazaUpperCase(List<String> listlist)
    {
        for (int i = 0; i < listlist.size(); i++) {
            System.out.println(listlist.get(i).toUpperCase(Locale.ROOT));
        }
    }

}