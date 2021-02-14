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

public class WinesApiTest {

    public static final String WINE_API_URL = "https://endavawineapp.azurewebsites.net/wines";

    public static final String WINE_NAME = "Denisa";
    public static final String BOTTLING_VOLUME = "ABC";
    public static final float WINE_VOLUME = 50;
    public static final String WINE_UNIT = "liters";

    public static final String COMPONENT1 = "first";
    public static final String COMPONENT2 = "second";
    public static final String COMPONENT3 = "third";
    public static List<String> COMPONENTS = new LinkedList<>(Arrays.asList(COMPONENT1, COMPONENT2, COMPONENT3));

    public static final String MUST_TYPE = "sweet";

    public static final String WINE_FINAL_NAME = "Denisa Pîntea";

    public final Logger LOGGER = Logger.getLogger(getClass().getName());
    public Response response;

    @Test
    public void testWinesApi() {

        checkWineDuplicates();
        LOGGER.info(WINE_NAME + " - Name is unique.");

        addWine(WINE_NAME, BOTTLING_VOLUME, WINE_VOLUME, WINE_UNIT, COMPONENTS, MUST_TYPE);
        LOGGER.info("Wine created.");

        getMusts();
        String id = getWineId(WINE_NAME);
        LOGGER.info("Wine id is:" + id);
        assertThat("id missing.", id, is(not(emptyString())));

        updateWineName(id);
        LOGGER.info("Wine name updated.");

        getMusts();
        assertThat("wine name was not updated.", isWineAvailable(WINE_FINAL_NAME), is(true));
    }

    public void checkWineDuplicates() {

        getMusts();
        assertThat(WINE_NAME + " - Name already used.", isWineAvailable(WINE_NAME), is(false));
    }

    public void getMusts() {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(WINE_API_URL);

        assertThat(response.getStatusCode(), is(200));
    }

    public void addWine(String name, String bottVol, float volume, String unit, List<String> components, String type) {

        Map<String, Object> volumeMap = new HashMap<>();
        volumeMap.put("value", volume);
        volumeMap.put("unit", unit);

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", name);
        bodyMap.put("bottlingVolume", bottVol);
        bodyMap.put("volume", volumeMap);
        bodyMap.put("composition", components);
        bodyMap.put("type", type);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post(WINE_API_URL);

        assertThat(response.getStatusCode(), is(200));
    }

    public String getWineId(String wineName) {

        return JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + wineName + "'}.id").toString();
    }

    public void updateWineName(String id) {

        Map<String, Object> body = new HashMap<>();
        body.put("name", WINE_FINAL_NAME);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch(WINE_API_URL + "/{id}", id);

        assertThat(response.getStatusCode(), is(200));
    }

    public Boolean isWineAvailable(String wineName) {

        return JsonPath.with(response.prettyPrint()).get("name").toString().contains(wineName);
    }
}
