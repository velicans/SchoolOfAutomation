package api;

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

public class MustApiTest {

    public static final String MUST_API_URL = "https://endavawineapp.azurewebsites.net/must";
    public static final String MUST_NAME = "mirela";
    public static final float MUST_VOLUME = 100;
    public static final String MUST_TYPE = "semi sweet";
    public final Logger LOGGER = Logger.getLogger(getClass().getName());

    public Response response;

    @Test
    public void testMustApi() {
        addMust(MUST_NAME, MUST_VOLUME, MUST_TYPE);
        LOGGER.info("Must has been created!");

        getMust();
        String id = getMustId(MUST_NAME);
        LOGGER.info("Must id is:" + id);
        assertThat("id not found.", id, is(not(emptyString())));

        deleteMust(id);
        LOGGER.info("Must deleted.");
        getMust();

        assertThat("Must was not deleted.", isMustAvailable(MUST_NAME), is(false));
    }


    public void getMust() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(MUST_API_URL);
        assertThat(response.getStatusCode(), is(200));
    }


    public void addMust(String name, float volume, String type) {
        Map<String, Object> mustVolumeMap = new HashMap<>();
        mustVolumeMap.put("value", volume);
        mustVolumeMap.put("unit", "liters");

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", name);
        bodyMap.put("volume", mustVolumeMap);
        bodyMap.put("type", type);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post(MUST_API_URL);
        assertThat(response.getStatusCode(), is(200));

    }


    public void deleteMust(String id) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("[" + id + "]")
                .when()
                .delete(MUST_API_URL);
        assertThat(response.getStatusCode(), is(200));
    }

    public String getMustId(String mustName) {

        return JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + mustName + "'}.id").toString();
    }

    public Boolean isMustAvailable(String mustName) {

        return JsonPath.with(response.prettyPrint()).get("name").toString().contains(mustName);
    }
}
