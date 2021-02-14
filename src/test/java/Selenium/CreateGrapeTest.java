package Selenium;


import PageObjects.GrapesPO;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateGrapeTest extends SeleniumTestBase {

    public static final String GRAPE_QUANTITY = "24";
    public static final String GRAPE_AGE = "6";
    public static final String GRAPE_RIPENESS = "95";

    GrapesPO grapesPO;

    @Test
    public void grapeTest() {

        addNewGrapes(GRAPE_NAME, GRAPE_QUANTITY, GRAPE_AGE, GRAPE_RIPENESS);

        grapesPO = new GrapesPO(driver);
        grapesPO.clickCrush(GRAPE_NAME);
        assertThat("could not find " + GRAPE_NAME, grapesPO.isSuccessAddGrapes(), is(true));

        sleep(3);
    }


}
