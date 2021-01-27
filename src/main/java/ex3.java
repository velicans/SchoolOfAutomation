public class ex3 {

    static int leapYear() {
        int[] List = new int[]{13, 17, 20};
        int i = 0;
        int an = 2021;
        while (i < 20) {
            if ((an % 4) == 0) {
                System.out.println(an);
                an++;
                i++;
                } else {
                    an++;
                    }

        }
    return an;
    }
    public static void main(String[] args){

        leapYear();
    }
}