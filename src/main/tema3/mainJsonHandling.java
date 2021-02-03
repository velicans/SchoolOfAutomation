import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


public class mainJsonHandling {

    public static void main(String[] args) throws ParseException {

        String string = JsonHandling.fileReaderIO("JsonExample");

        JSONObject json = JsonHandling.parseFileToJson(string);
        System.out.println(json.size());
        System.out.println("contains value sildenafil citrate =   " + json.containsValue("sildenafil citrate"));
        System.out.println("contains key product_name =   " + json.containsKey("product_name"));

        String string2 = JsonHandling.fileReaderIO("JsonWithListOfJsons");

        JSONObject json2 = JsonHandling.parseFileToJson(string2);
        System.out.println(json2.size());

        //buba
        System.out.println("contains value sildenafil =   " + json2.containsValue("sildenafil"));
        System.out.println("contains key product_name =   " + json2.containsKey("product_name"));


    }

}
