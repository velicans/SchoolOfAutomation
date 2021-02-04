package day4exercises;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    Path path;
    File file;
    String extension;

    /**
     * Reads and parses into JSONOBject
     * @param filename name of the file to be parsed
     */
    JsonParser(String filename, String extension) {
        path = Paths.get(System.getProperty("user.dir"), "PracticeFiles", filename + extension);//
        file = new File(String.valueOf(path));

        this.extension=extension;

        //System.out.println(file.toString());

    }
    /**
     * Reads and returns a String of the read file.
     * @return String
     */
    private String fileReader() {
        List<String> strings = new ArrayList<>();
        try {
            strings = FileUtils.readLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Catched error");
        }


        String toReturn="";
        for (String s : strings){
            toReturn=toReturn+s;
        }

        return toReturn;

    }

    /**
     * Parses the String from the read file into JSONObject
     * @return JSONObject
     */
    public JSONObject jsonParser (){
        //System.out.println(fileReader());
        JSONObject obj = new JSONObject(fileReader());
        return obj;

    }

    /**
     * Sets the file path and extension
     * @param filename String of the filename
     */
    public void setPathAndFile(String filename,String extension) {
        path = Paths.get(System.getProperty("user.dir"), "PracticeFiles", filename + extension);//
        file = new File(String.valueOf(path));
        this.extension=extension;
    }

    /**
     * Returns the current file extension
     * @return String extension
     */
    public String getExtension() {
        return extension;
    }
    /**
     * Sets the current file extension
     * */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Get current file path
     * @return Path path
     */
    public Path getPath() {
        return path;
    }



}
