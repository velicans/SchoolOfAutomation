package seleniumtests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Logger;

public class SeleniumTests {

    static final String GRAPE_NAME = "Test alex 2";
    static final String GRAPE_QUANTITY = "24";
    static final String GRAPE_AGE = "90";
    static final String GRAPE_RIPENESS = "90";

    static GrapesPO grapesTests;
    static MustPO mustTests;
    static WinesPO winesTests;

    final Logger LOGGER = Logger.getLogger(getClass().getName());


    @Test
    @DisplayName("testGrapes")
    public void testGrapes() {

        //Grapes page tests
        grapesTests = new GrapesPO(GRAPE_NAME, GRAPE_QUANTITY, GRAPE_AGE, GRAPE_RIPENESS);
        grapesTests.addGrape();
        LOGGER.info("Grapes added");

        grapesTests.crushGrapes();
        LOGGER.info("Grapes crushed");

        grapesTests.closeDriver();

        //Must page tests
        mustTests = new MustPO(GRAPE_NAME);
        mustTests.goToMust();
        mustTests.findMust();
        LOGGER.info("Must found");

        mustTests.fermentMust();
        LOGGER.info("Must fermented");

        mustTests.closeDriver();

        //Wines page tests
        winesTests = new WinesPO(GRAPE_NAME);
        winesTests.goToWines();
        winesTests.findWine();
        LOGGER.info("Wine found");

        winesTests.setName();
        LOGGER.info("Name set");

        winesTests.setBottlingVolume();
        LOGGER.info("Bottling set");

        winesTests.closeDriver();


    }


}
