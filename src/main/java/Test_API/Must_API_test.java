package Test_API;

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

public class Must_API_test {

        public static final String MUST_API_URL = "https://endavawineapp.azurewebsites.net/must";
        public static final String MUST_NAME = "Mada5"; // schimba valoarea pentru a avea un nou tip de strugure
        public static final float MUST_VOLUME= 245;
        public static final String MUST_TYPE = "sweet";
        public final Logger LOGGER = Logger.getLogger(getClass().getName());

        public Response response;

        @Test
        public void testMustApi() {

            addMust(MUST_NAME, MUST_VOLUME, MUST_TYPE);
            LOGGER.info("Must created.");

            getMust();
            String id = getMustId(MUST_NAME);
            LOGGER.info("Must id is:" + id);
            assertThat("id missing.", id, is(not(emptyString())));
            assertThat("name is not available", isMustNameAvailable(MUST_NAME),is(true));

            deleteMust(id);
            LOGGER.info("Must deleted.");
            getMust();

            assertThat("Must name was not deleted.", isMustNameAvailable(MUST_NAME), is(false));
        }


        public String getMustId(String mustName) {

            return JsonPath.with(response.prettyPrint()).get("find { a -> a.name == '" + mustName + "'}.id").toString();
        }

        public Boolean isMustNameAvailable(String mustName) {

            return JsonPath.with(response.prettyPrint()).get("name").toString().contains(mustName);
        }

         public Boolean isMustIdAvailable(String mustName) {

        return JsonPath.with(response.prettyPrint()).get("id").toString().contains(mustName);
        }
        public void addMust(String name, float volume, String type) {

            Map<String, Object> quantityMap = new HashMap<>();
            quantityMap.put("value", volume);
            quantityMap.put("unit", "liters");

            Map<String, Object> bodyMap = new HashMap<>();
            bodyMap.put("name", name);
            bodyMap.put("quantity", quantityMap);


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
                    .when()
                    .delete(MUST_API_URL + id);

            assertThat(response.getStatusCode(), is(200));

        }

        public void getMust() {

            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(MUST_API_URL);

            assertThat(response.getStatusCode(), is(200));

        }


    }
