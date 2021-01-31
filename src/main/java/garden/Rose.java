public class Rose extends Plant{
    String color = "yellow";
    public Rose(){

    }

    //aici am creattamplate de comportament
    public Rose(String color){
        this.color = color;
    }

    public String color(){
        return color;
    }
}
