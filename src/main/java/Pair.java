public class Pair {

    private int myNumber;
    private String myValue;
/*
    public Pair() {
        this.myNumber = 0;
        this.myValue = "";
    }*/

    public Pair(int myNumber, String myValue) {
        this.myNumber = myNumber;
        this.myValue = myValue;
    }

    public String getMyValue() {
        return myValue;
    }

    public void setMyValue(String myValue) {
        this.myValue = myValue;
    }

    public int getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(int myNumber) {
        this.myNumber = myNumber;
    }
}
