import java.util.Locale;

public class ex4 {


   public static void lowerCase() {

        String[] List = new String[]{"Welcome","TO","ThE","SchooL","oF","AUTOmation"};

                for (int i = 0; i < List.length; i++) {

                    List[i]=List[i].toLowerCase();
                    System.out.print (List[i].toLowerCase()+" ");
                }

        }

    public static void main(String[] args){
        lowerCase();

    }


}