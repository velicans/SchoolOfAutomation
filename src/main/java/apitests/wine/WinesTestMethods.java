package apitests.wine;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;


public class WinesTestMethods {

    Response response;

    final String WINE_NAME;
    final String WINE_VOLUME;
    final float WINE_VALUE;
    final String WINE_UNIT;
    final List<String> WINE_COMPOSITION;
    final String WINE_TYPE;

    final String WINE_API_URL;

    WinesTestMethods(String name, String volume, float value, String unit, List<String> wine_composition, String type, String api_url) {
        WINE_NAME = name;
        WINE_VOLUME = volume;
        WINE_VALUE = value;
        WINE_UNIT = unit;
        WINE_COMPOSITION = wine_composition;
        WINE_TYPE = type;
        WINE_API_URL = api_url;

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(WINE_API_URL);
    }

    public void addWine() {
        Map<String, Object> volumeMap = new HashMap<>();
        volumeMap.put("value", WINE_VALUE);
        volumeMap.put("unit", WINE_UNIT);


        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", WINE_NAME);
        bodyMap.put("bottlingVolume", WINE_VOLUME);
        bodyMap.put("volume", volumeMap);
        bodyMap.put("composition", WINE_COMPOSITION);
        bodyMap.put("type", WINE_TYPE);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post(WINE_API_URL);

        assertThat(response.getStatusCode(), is(200));

    }

    public String getWineID() {
        String id = JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + WINE_NAME + "'}.id").toString();
        assertThat(id, is(not(emptyString())));
        return id;
    }

    public void deleteWine() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete(WINE_API_URL + getWineID());

        assertThat(response.getStatusCode(), is(200));
    }

    public void getWine() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(WINE_API_URL);

        assertThat(response.getStatusCode(), is(200));
    }

    public void isWineAvailable() {
        boolean testCase = JsonPath.with(response.prettyPrint()).get("name").toString().contains(WINE_NAME);
        assertThat(testCase, is(false));
    }

    public void modifyName() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .param("name", WINE_NAME)
                .patch(WINE_API_URL + getWineID());


        assertThat(response.getStatusCode(), is(200));
    }


}
