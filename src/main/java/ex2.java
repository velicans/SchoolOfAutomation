import java.util.Arrays;
public class ex2 {

//regular for loop
   static int sumOfList1() {

        int[] List = new int[]{13, 17, 20};
        int Sum = 0;
        for (int i = 0; i < List.length; i++) {
            Sum = Sum + List[i];
        }
        System.out.println("Folosind regular for loop suma e "+ Sum);
   return Sum;
    }

    //for-each loop
    static int sumOfList2(){

        int[] List = new int[]{13, 17, 20};
        int Sum = 0;
        for (int element : List){
            Sum = Sum + element;
        }
        System.out.println("Folosind for-each loop suma e "+ Sum);
    return Sum;
    }

    //while loop
    static int sumOfList3(){
        int[] List = new int[]{13, 17, 20};
        int Sum = 0;
        int i=0;
        while (i<List.length){
            Sum = Sum + List[i];
            i++;
        }
        System.out.println("Folosind while loop suma e "+ Sum);
    return Sum;
    }

    public static void main(String[] args){
        sumOfList1();
        sumOfList2();
        sumOfList3();


    }


}