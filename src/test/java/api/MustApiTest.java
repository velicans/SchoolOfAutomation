package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;

public class MustApiTest {

    public static final String MUST_API_URL = "https://endavawineapp.azurewebsites.net/must";

    public static final String MUST_NAME = "Denisa";
    public static final float MUST_VOLUME = 50;
    public static final String MUST_UNIT = "liters";
    public static final String MUST_TYPE = "sweet";

    public final Logger LOGGER = Logger.getLogger(getClass().getName());
    public Response response;

    @Test
    public void testMustApi() {

        checkDuplicates();
        LOGGER.info(MUST_NAME + " - Name is unique.");

        addMust(MUST_NAME, MUST_VOLUME, MUST_UNIT, MUST_TYPE);
        LOGGER.info("Must created.");

        getMusts();
        String id = getMustId(MUST_NAME);
        LOGGER.info("Must id is:" + id);
        assertThat("id missing.", id, is(not(emptyString())));

        deleteMust(id);
        LOGGER.info("Must deleted.");

        getMusts();
        assertThat("nust was not deleted.", isMustAvailable(MUST_NAME), is(false));
    }

    public void checkDuplicates() {

        getMusts();
        assertThat(MUST_NAME + " - Name already used.", isMustAvailable(MUST_NAME), is(false));
    }

    public void addMust(String name, float volume, String unit, String type) {

        Map<String, Object> volumeMap = new HashMap<>();
        volumeMap.put("value", volume);
        volumeMap.put("unit", unit);

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", name);
        bodyMap.put("volume", volumeMap);
        bodyMap.put("type", type);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post(MUST_API_URL);

        assertThat(response.getStatusCode(), is(200));
    }

    public void getMusts() {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(MUST_API_URL);

        assertThat(response.getStatusCode(), is(200));
    }

    public String getMustId(String mustName) {

        return JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + mustName + "'}.id").toString();
    }

    public void deleteMust(String id) {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("[" + id + "]")
                .when()
                .delete(MUST_API_URL);

        assertThat(response.getStatusCode(), is(200));
    }

    public Boolean isMustAvailable(String mustName) {

        return JsonPath.with(response.prettyPrint()).get("name").toString().contains(mustName);
    }
}
