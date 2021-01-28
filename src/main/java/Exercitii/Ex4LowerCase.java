package Exercitii;

//  4. Write a method that iterates through a list of Strings and makes them lowercase

import java.util.List;

public class Ex4LowerCase {

        public void CastListToLowerCase(List<String> listOfStrings) {
            for(int i=0,l=listOfStrings.size();i<l;++i)
            {
                listOfStrings.set(i, listOfStrings.get(i).toLowerCase());
            }
            System.out.println(listOfStrings);
        }
    }

