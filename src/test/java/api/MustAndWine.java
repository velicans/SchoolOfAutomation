package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;

public class MustAndWine {
    public static final String Must_API_URL = "https://endavawineapp.azurewebsites.net/must";
    public static final String Wine_API_URL = "https://endavawineapp.azurewebsites.net/wines/";

    public Response response;

    @Test
    public void testMustApi() {
        getMust();

        String mustID =  getMustId("godello");
        deleteMust(mustID);

        postMust(3, "godello2","sweet", 1000);

    }


    public void getMust() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(Must_API_URL);
        assertThat(response.getStatusCode(), is(200));
    }


    public String getMustId(String MustName) {
        return JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + MustName + "'}.id").toString();
    }

    public void deleteMust(String id) {

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("["+id+"]")
                .when()
                .delete(Must_API_URL);

        assertThat(response.getStatusCode(), is(200));

    }

    public void postMust(Integer id, String name, String type, Integer value) {
        HashMap bodyMap = new HashMap();
        bodyMap.put("id",id);  //cheie valoare
        bodyMap.put("name", name);
        bodyMap.put("type", type);

        HashMap bodyMap2 = new HashMap();
        bodyMap2.put("value", value);
        bodyMap2.put("unit", "liters");

        bodyMap.put("volume", bodyMap2);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post(Must_API_URL);

        assertThat(response.getStatusCode(), is(200));

    }

    @Test
    public void testWineApi() {
        patchWine("daniel6");
        getWine();
        postWine("daniel55", "sweet", 1000, "sauvignon blanc");
    }

    public void patchWine(String name) {
        HashMap bodyMap = new HashMap();
        bodyMap.put("name", name);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .patch(Wine_API_URL + 6);

        assertThat(response.getStatusCode(), is(200));
    }

    public void getWine() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(Wine_API_URL);
        assertThat(response.getStatusCode(), is(200));
    }

    public void postWine(String name, String type, Integer value, String comp) {
        HashMap bodyMap = new HashMap();
        bodyMap.put("name", name);
        bodyMap.put("bottlingVolume", "");

        HashMap bodyMap2 = new HashMap();
        bodyMap2.put("value", value);
        bodyMap2.put("unit", "liters");

        bodyMap.put("volume", bodyMap2);

        bodyMap.put("type", type);

        ArrayList<String> composition = new ArrayList<String>();
        composition.add(comp);
        bodyMap.put("composition", composition.toArray());

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post(Wine_API_URL);

        assertThat(response.getStatusCode(), is(200));

    }

}
