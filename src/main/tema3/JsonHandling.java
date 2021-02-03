import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class JsonHandling {


    public static String fileReaderIO(String filename) {
        Path textLocation = Paths.get(System.getProperty("user.dir"), "Files", filename + ".json");
        File file = new File(String.valueOf(textLocation));

        String lines = "";

        try {
            lines = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

            System.out.println(lines);

        } catch (IOException e) {
            System.out.println("Catched something");
        }
        return lines;
    }

    public static JSONObject parseFileToJson (String s) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(s);

        return json;

    }



    }


