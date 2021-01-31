package Examples.Tema1;

public class Ex3LeapYears {
    public static void main(String[] args) {
        int n = 2024;
        int i = 1;
        do {
            if (n % 4 == 0)
                System.out.println(n);
            n += 4;
            i += 1;
        } while (i < 21);
    }
}