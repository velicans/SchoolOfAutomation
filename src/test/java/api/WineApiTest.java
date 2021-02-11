package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;

public class WineApiTest {

    public static final String WINE_API_URL = "https://endavawineapp.azurewebsites.net/wines";

    public static final String WINE_NAME = "Andrei Wine2";
    public static final float WINE_VOLUME = 120;
    public static final String WINE_TYPE = "demisec";
    public static final String WINE_BOTTLING = "Magnum";
    public static final List<String> WINE_COMPOSITION = Arrays.asList("Feteasca alba", "Feteasca regala", "Pinot gris");
    public static final String WINE_NEW_NAME = "Andrei Wine2 Patch";

    public final Logger LOGGER = Logger.getLogger(getClass().getName());

    public Response response;

    @Test
    public void testWineApi() {

        postWine(WINE_NAME,WINE_BOTTLING,WINE_VOLUME,WINE_COMPOSITION,WINE_TYPE);
        LOGGER.info("Wine created.");

        getWine();
        String id = getWineId(WINE_NAME);
        LOGGER.info("Wine id is:" + id);
        assertThat("id missing.", id, is(not(emptyString())));


        patchWine(id, WINE_NEW_NAME);
        LOGGER.info("Wine patched.");
        getWine();

        assertThat("Wine was not deleted.", isWineIdAvailable(id), is(true));
        assertThat("Wine name is not available", isWineNameAvailable(WINE_NEW_NAME),is(true));
      //  assertThat("Wine name is available", isWineNameAvailable(WINE_NAME),is(false));

    }


    public String getWineId(String wineName) {

        return JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + wineName + "'}.id").toString();
    }

    public Boolean isWineNameAvailable(String wineName) {

        return JsonPath.with(response.prettyPrint()).get("name").toString().contains(wineName);

    }

    public Boolean isWineIdAvailable(String wineId) {

        return JsonPath.with(response.prettyPrint()).get("id").toString().contains(wineId);

    }

    public void postWine(String name, String bottlingVolume, float volume, List<String> composition, String type) {

        Map<String, Object> volumeMap = new HashMap<>();
        volumeMap.put("value", volume);
        volumeMap.put("unit", "liters");

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", name);
        bodyMap.put("bottlingVolume", bottlingVolume);
        bodyMap.put("volume", volumeMap);
        bodyMap.put("composition", composition);
        bodyMap.put("type", type);



        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post(WINE_API_URL);

        assertThat(response.getStatusCode(), is(200));

    }

    public void patchWine(String id, String name) {

        Map<String, Object> patchBodyMap = new HashMap<>();
        patchBodyMap.put("name", name);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .body(patchBodyMap)
                .when()
                .patch(WINE_API_URL + "/{id}");

        assertThat(response.getStatusCode(), is(200));


    }

    public void getWine() {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(WINE_API_URL);

        assertThat(response.getStatusCode(), is(200));

    }


}
