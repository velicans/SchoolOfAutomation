package apitests.wine;

import apitests.must.MustTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class WineTests {
    public static final String WINE_API_URL = "https://endavawineapp.azurewebsites.net/wines/";
    public static final String WINE_NAME = MustTest.MUST_NAME;
    public static final String WINE_VOLUME = "35";
    public static final float WINE_VALUE = 100;
    public static final String WINE_UNIT = MustTest.MUST_UNIT;
    public static final List<String> WINE_COMPOSITION = Arrays.asList(new String[]{"merlot1", "shiraz1"});
    public static final String WINE_TYPE = MustTest.MUST_TYPE;

    public final Logger LOGGER = Logger.getLogger(getClass().getName());


    static WinesTestMethods testMethods;

    @BeforeAll
    public static void initVar() {
        testMethods = new WinesTestMethods(WINE_NAME, WINE_VOLUME, WINE_VALUE, WINE_UNIT, WINE_COMPOSITION, WINE_TYPE, WINE_API_URL);
    }

    @BeforeEach
    public void initWine() {
        testMethods.getWine();
    }

    @Test
    @DisplayName("testAddWine")
    public void testAddWine() {
        testMethods.addWine();
        LOGGER.info("Wine added");
    }

    @Test
    @DisplayName("testDeleteWine")
    public void testDeleteWine() {
        testMethods.deleteWine();
        LOGGER.info("Wine deleted");
        testMethods.isWineAvailable();
    }

    @Test
    @DisplayName("testModifyName")
    public void testModifyName() {
        testMethods.modifyName();
    }


}
