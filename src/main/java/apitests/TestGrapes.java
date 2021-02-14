package apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;

public class TestGrapes {

    public static final String GRAPE_API_URL = "https://endavawineapp.azurewebsites.net/grapes/";

    public static final String GRAPE_NAME = "Alex test"; // schimba valoarea pentru a avea un nou tip de strugure
    public static final float GRAPE_QUANTITY = 12;
    public static final int GRAPE_AGE = 5;
    public static final float GRAPE_RIPENESS = 99; // daca valoarea este pe 87.0 o sa avem butonul "pick & crush grapes"
    public final Logger LOGGER = Logger.getLogger(getClass().getName());

    public Response response;

    @Test
    public void testGrapeApi() {

        addGrape(GRAPE_NAME, GRAPE_QUANTITY, GRAPE_AGE, GRAPE_RIPENESS);
        LOGGER.info("Grape created.");

        getGrapes();
        String id = getGrapeId(GRAPE_NAME);
        LOGGER.info("Grape id is:" + id);
        assertThat("id missing.", id, is(not(emptyString())));

        deleteGrape(id);
        LOGGER.info("Grape deleted.");
        getGrapes();

        assertThat("grape was not deleted.", isGrapeAvailable(GRAPE_NAME), is(false));
    }


    public String getGrapeId(String grapeName) {

        return JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + grapeName + "'}.id").toString();
    }

    public Boolean isGrapeAvailable(String grapeName) {

        return JsonPath.with(response.prettyPrint()).get("name").toString().contains(grapeName);
    }

    public void addGrape(String name, float quantity, int age, float ripeness) {

        Map<String, Object> quantityMap = new HashMap<>();
        quantityMap.put("value", quantity);
        quantityMap.put("unit", "rows");

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", name);
        bodyMap.put("quantity", quantityMap);
        bodyMap.put("age", age);
        bodyMap.put("ripeness", ripeness);


        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post(GRAPE_API_URL);

        assertThat(response.getStatusCode(), is(200));

    }

    public void deleteGrape(String id) {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete(GRAPE_API_URL + id);

        assertThat(response.getStatusCode(), is(200));

    }

    public void getGrapes() {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(GRAPE_API_URL);

        assertThat(response.getStatusCode(), is(200));

    }


}