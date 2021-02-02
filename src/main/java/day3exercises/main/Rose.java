package day3exercises.main;

public class Rose extends Plant implements Eatable{
    Rose(int oxygen){
        super(oxygen);
    }

    public boolean isEatable(){
        return false;
    }

}
