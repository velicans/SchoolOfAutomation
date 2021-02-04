package day4exercises;

public class Adresa {
    String cityName;
    String streetName;
    int streetNumber;

    Adresa(String city, String street, int streetNumber){
        this.cityName=city;
        this.streetName=street;
        this.streetNumber=streetNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public String toString() {
        return cityName+" "+streetName+" "+streetNumber;
    }
}
