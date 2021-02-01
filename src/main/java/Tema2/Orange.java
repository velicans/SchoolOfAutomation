package Tema2;

public class Orange extends Plant implements Fructiferous, Eatable {
    int age ;
    int height;

 public String getTimeToHarvest() {
        return "August";
        }

 public Boolean isEatable(){
     return true;
     }
    }

