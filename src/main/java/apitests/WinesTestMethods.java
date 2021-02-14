package apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class WinesTestMethods {

    Response response;

    final String WINE_NAME;
    final String WINE_VOLUME;
    final float WINE_VALUE;
    final String WINE_UNIT;
    final List<String> WINE_COMPOSITION;
    final String WINE_TYPE;

    final String WINE_API_URL;

    WinesTestMethods(String name, String volume, float value, String unit, List<String> wine_composition, String type,String api_url){
        WINE_NAME=name;
        WINE_VOLUME=volume;
        WINE_VALUE=value;
        WINE_UNIT=unit;
        WINE_COMPOSITION=wine_composition;
        WINE_TYPE=type;
        WINE_API_URL=api_url;

        response=RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(WINE_API_URL);
    }

    public void addWine(){
        Map<String, Object> volumeMap = new HashMap<>();
        volumeMap.put("value",WINE_VALUE);
        volumeMap.put("unit",WINE_UNIT);

        Map<String, Object> compositionMap = new HashMap<>();
        compositionMap.put("composition",WINE_COMPOSITION);

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", WINE_NAME);
        bodyMap.put("bottlingVolume",WINE_VOLUME);
        bodyMap.put("volume",volumeMap);
        bodyMap.put("composition",compositionMap);
        bodyMap.put("type",WINE_TYPE);

        response=RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post(WINE_API_URL);

    }

    public String getWineID(){
        return JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + WINE_NAME + "'}.id").toString();
    }









}
