package exercises;

import java.util.List;
import java.util.stream.Collectors;

public class DoubleOfNumbers {


    /**
     * This method takes a list of Integers and turns all elements to their double (multiplies by 2)
     *
     * @param numbers
     * @return a List of Integers which are the doubles of the List @ param
     */
    public static List<Integer> makeDoubleNumberList(List<Integer> numbers) {

        return numbers
                .stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }
}
