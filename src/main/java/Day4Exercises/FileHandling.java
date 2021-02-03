package Day4Exercises;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandling {

    public static JSONObject jsonReaderIO(String filename) {

        Path textLocation = Paths.get(System.getProperty("user.dir"), "PracticeFiles", filename + ".json");
        File file = new File(String.valueOf(textLocation));

        try {
            String lines = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            return new JSONObject(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Print a JSONObject with the format
     * {
     * "product_name":
     * "supplier":
     * "quantity":
     * "unit_cost":
     * }
     *
     * @param myJson type JSONObject
     */
    private static void printSimpleJsonObject(JSONObject myJson) {

        System.out.println("\tProduct name: " + myJson.getString("product_name"));
        System.out.println("\tSupplier    : " + myJson.getString("supplier"));
        System.out.println("\tQuantity    : " + myJson.getInt("quantity"));
        System.out.println("\tUnit cost   : " + myJson.getString("unit_cost"));
    }


    /**
     * Print a JSONObject with the format
     * {
     * "product_name":
     * "supplier":
     * "quantity":
     * "unit_cost":
     * "listJSon": []    <- optional
     * }
     *
     * @param myJson type JSONObject
     */
    public static void printJsonObject(JSONObject myJson) {

        System.out.println("Product name: " + myJson.getString("product_name"));
        System.out.println("Supplier    : " + myJson.getString("supplier"));
        System.out.println("Quantity    : " + myJson.getInt("quantity"));
        System.out.println("Unit cost   : " + myJson.getString("unit_cost"));

        if (myJson.has("listJSon")) {

            JSONArray listJson = myJson.getJSONArray("listJSon");
            System.out.println("List Json   : ");

            for (int i = 0; i < listJson.length(); i++) {
                printSimpleJsonObject(listJson.getJSONObject(i));
                System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }
    }
}
