public class ex5 {


   public static void doubleNo() {

        int[] List = new int[]{5, 8, 11};
        for (int i = 0; i < List.length; i++) {
            List[i] = List[i] * 2;
            System.out.print(List[i] + " ");
        }

    }


    public static void main(String[] args){
       System.out.print("Lista numerelor dublate este: ");
       doubleNo();

    }


}