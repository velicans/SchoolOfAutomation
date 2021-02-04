package day4exercises;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        JsonParser parser = new JsonParser("JsonExample",".json");

        JSONObject obj = parser.jsonParser();

        printJson(obj);

        parser.setPathAndFile("JsonWithListOfJsons",".json");


        JSONObject mainObj;
        JSONArray listObj;

        mainObj = parser.jsonParser();
        listObj = mainObj.getJSONArray("listJSon");

        printJson(mainObj);
        printJson(listObj);




    }


    public static void printJson(JSONObject json) {
        System.out.println("JSON:");
        System.out.println("product_name : " + json.getString("product_name"));
        System.out.println("supplier : " + json.getString("supplier"));
        System.out.println("quantity : " + json.getInt("quantity"));
        System.out.println("unit_cost : " + json.getString("unit_cost"));

    }

    public static void printJson(JSONArray json) {
        System.out.println("JSON array");
        for (int i = 0; i < json.length(); i++) {
            System.out.println("product_name : " + json.getJSONObject(i).getString("product_name"));
            System.out.println("supplier : " + json.getJSONObject(i).getString("supplier"));
            System.out.println("quantity : " + json.getJSONObject(i).getInt("quantity"));
            System.out.println("unit_cost : " + json.getJSONObject(i).getString("unit_cost"));
        }
    }


}
