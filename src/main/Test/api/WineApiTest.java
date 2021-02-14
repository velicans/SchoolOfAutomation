package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

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
    public static final String WINE_NAME = "mirela";
    public static final String BOTTLING_VOLUME = "";
    public static final float WINE_VOLUME = 100;
    public static final List<String> composition = List.of("Chardonnay", "Merlot", "Pinot Noir");
    public static final String WINE_TYPE = "dry";
    public static final String WINE_NAME_TEST = "test";


    public final Logger LOGGER = Logger.getLogger(getClass().getName());

    public Response response;


    @Test
    public void testWinesApi() {
        addWine(WINE_NAME, BOTTLING_VOLUME, WINE_VOLUME, composition, WINE_TYPE);
        LOGGER.info("Wine has been created");

        getWines();
        String id = getWineId(WINE_NAME);
        LOGGER.info("Wine id is:" + id);
        assertThat("id missing.", id, is(not(emptyString())));


        patchWine(WINE_NAME_TEST, id);
        assertThat("Wine name not changed", isWineAvailable(WINE_NAME_TEST), is(true));
        getWines();
    }


    public void getWines() {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(WINE_API_URL);

        response.prettyPrint();
        assertThat(response.getStatusCode(), is(200));

    }

    public void addWine(String wineName, String bottlingVolume, float wineVolume, List<String> composition, String type) {

        Map<String, Object> wineVolumeMap = new HashMap<>();
        wineVolumeMap.put("value", wineVolume);
        wineVolumeMap.put("unit", "liters");

        Map<String, Object> wineBodyMap = new HashMap<>();
        wineBodyMap.put("name", wineName);
        wineBodyMap.put("bottlingVolume", bottlingVolume);
        wineBodyMap.put("volume", wineVolumeMap);
        wineBodyMap.put("composition", composition);
        wineBodyMap.put("type", type);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(wineBodyMap)
                .when()
                .post(WINE_API_URL);


        assertThat(response.getStatusCode(), is(200));
    }


    public void patchWine(String wineName, String id) {

        Map<String, Object> editWineBodyMap = new HashMap<>();
        editWineBodyMap.put("name", wineName);
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam(WINE_API_URL, id)
                .body(editWineBodyMap)
                .when()
                .patch(WINE_API_URL);  // is PATCH method allowed? response from server 405

        response.prettyPrint();
        assertThat(response.getStatusCode(), is(200));
    }

    public String getWineId(String wineName) {

        return JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + wineName + "'}.id").toString();
    }

    public Boolean isWineAvailable(String wineName) {

        return JsonPath.with(response.prettyPrint()).get("name").toString().contains(wineName);
    }

}
