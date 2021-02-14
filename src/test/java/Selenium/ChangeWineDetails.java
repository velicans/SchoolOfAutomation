package Selenium;

import PageObjects.WinesPO;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeWineDetails extends SeleniumTestBase {

    public static final String WINE_COMPOSITION = GRAPE_NAME + ", Denisa 2";
    public static final String FINAL_NAME = "Denisa Pîntea";
    public static final String BOTTLING_VOLUME = "ABC";

    WinesPO winesPO;

    @Test
    public void testChangeDetails() {

        changePageToWines();
        waitForElementToBeVisible(By.xpath("//h3[contains(text(),'Wine cellar contents:')]"));

        winesPO = new WinesPO(driver);

        winesPO.checkWine(WINE_COMPOSITION);
        assertThat("wine with the given composition not found", winesPO.wineExists(), is(true));

        winesPO.changeName(WINE_COMPOSITION, FINAL_NAME);
        assertThat("there is no wine with the name " + FINAL_NAME, winesPO.okChangeName(), is(true));

        winesPO.changeBottlingVolume(WINE_COMPOSITION, BOTTLING_VOLUME);
        assertThat("there is no wine with the bottling volume " + BOTTLING_VOLUME,
                winesPO.okChangeBottling(), is(true));

        sleep(3);
    }
}
