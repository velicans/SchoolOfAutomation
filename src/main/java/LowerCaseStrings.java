import java.util.List;
import java.util.stream.Collectors;

public class LowerCaseStrings {

    /**
     * This method brings all elements of the @param list to lowerCase
     *
     * @param stringList
     * @return list of Strings in lowerCase
     */
    public static List<String> makeStringsLowerCase(List<String> stringList) {
        return stringList
                .stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
