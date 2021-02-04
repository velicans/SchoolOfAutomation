package day4exercises;

public class Persoane implements Comparable<Persoane> {

    private String name;
    private int age;

    Persoane(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Persoane o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.name+" "+this.age;
    }

    @Override
    public boolean equals(Object o) {
        Persoane p = (Persoane) o;
        return p.compareTo(this)==0;
    }
}
