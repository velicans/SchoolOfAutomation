package exercises;

import java.util.List;

public class SumNumbers {
    public static Integer sumWithFor(List<Integer> numbersList) {
        Integer sum = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            sum += numbersList.get(i);
        }
        return sum;
    }

    public static Integer sumWithEnhancedFor(List<Integer> numbersList) {
        Integer sum = 0;
        for (Integer n : numbersList) {
            sum += n;
        }
        return sum;
    }

    public static Integer sumWithWhile(List<Integer> numbersList) {
        Integer sum = 0;
        int i = 0;
        while (i < numbersList.size()) {
            sum += numbersList.get(i);
            i++;
        }

        return sum;
    }

}
