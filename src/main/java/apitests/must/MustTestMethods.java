package apitests.must;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;

public class MustTestMethods {

    Response response;
    public final String MUST_NAME;
    public final float MUST_VALUE;
    public final String MUST_UNIT;
    public final String MUST_TYPE;
    public final String MUST_API_URL;


    MustTestMethods(String must_name, float must_value, String must_unit, String must_type, String must_url) {
        MUST_NAME = must_name;
        MUST_VALUE = must_value;
        MUST_UNIT = must_unit;
        MUST_TYPE = must_type;
        MUST_API_URL = must_url;


        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(MUST_API_URL);
    }


    public void addMust() {
        Map<String, Object> volumeMap = new HashMap<>();
        volumeMap.put("value", MUST_VALUE);
        volumeMap.put("unit", MUST_UNIT);

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("name", MUST_NAME);
        bodyMap.put("volume", volumeMap);
        bodyMap.put("type", MUST_TYPE);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post(MUST_API_URL);

        assertThat(response.getStatusCode(), is(200));
    }

    public void deleteMust() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete(MUST_API_URL + getMustID());

        assertThat(response.getStatusCode(), is(200));
    }

    public String getMustID() {
        String id = JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + MUST_NAME + "'}.id").toString();
        assertThat(id, is(not(emptyString())));
        System.out.println("ID is "+id);
        return id;


    }

    public void getMust() {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(MUST_API_URL);


        assertThat(response.getStatusCode(), is(200));
    }

    public void isMustAvailable() {
        boolean testCase = JsonPath.with(response.prettyPrint()).get("name").toString().contains(MUST_NAME);
        assertThat(testCase, is(false));
    }

}
