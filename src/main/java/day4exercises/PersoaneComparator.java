package day4exercises;

import java.util.Comparator;

public class PersoaneComparator implements Comparator<Persoane> {
    @Override
    public int compare(Persoane o1, Persoane o2) {

        if (o1.getAge()==o2.getAge()){
            return o1.compareTo(o2);
        }
        return o1.getAge()-o2.getAge();
    }

}
