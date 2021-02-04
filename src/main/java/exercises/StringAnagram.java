package exercises;

import java.util.Arrays;

public class StringAnagram {

    /**
     * This method compares two strings: if one is the anagram of the other.
     *
     * @param string1
     * @param string2
     * @return true or false
     */
    public static boolean isAnagram(String string1, String string2) {

        if (string1.length() != string2.length())
            return false;
        char[] string1Array = string1.toCharArray();
        char[] string2Array = string2.toCharArray();
        Arrays.sort(string1Array);
        Arrays.sort(string2Array);
        return Arrays.equals(string1Array, string2Array);
    }
}
