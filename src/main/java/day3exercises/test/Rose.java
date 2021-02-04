package day3exercises.test;

import netscape.javascript.JSObject;

public class Rose extends Plant {
    Rose(int oxygen) {
        super(oxygen);
    }

    Rose(int oxygen, int age, int height, String color) {
        super(oxygen);
        this.age = age;
        this.height = height;
        this.color = color;
    }

    public boolean isEatable() {
        return false;
    }


    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getTimeToHarvest() {
        return null;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
}
