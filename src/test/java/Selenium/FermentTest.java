package Selenium;

import PageObjects.MustPO;
import PageObjects.WinesPO;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FermentTest extends SeleniumTestBase {

    public static final String COMPONENT1 = "Denisa 1";
    public static final String COMPONENT2 = "Denisa 2";
    public static List<String> COMPONENTS = new LinkedList<>(Arrays.asList(GRAPE_NAME, COMPONENT2));

    MustPO mustPO;
    WinesPO winesPO;

    @Test
    public void mustTest() {

        changePageToMust();

        waitForElementToBeVisible(By.xpath("//h3[contains(text(),'Must:')]"));

        mustPO = new MustPO(driver);
        checkComponents();

        List<String> out = mustPO.clickFerment(COMPONENTS);
        assertThat("could not find all the required components. ", out.isEmpty(), is(true));

        click(By.tagName("button"));

        winesPO = new WinesPO(driver);
        waitForElementToBeVisible(By.xpath("//h3[contains(text(),'Wine cellar contents:')]"));
        winesPO.checkWine(mustPO.getComposition().toString());
        assertThat("wine with the given composition not found", winesPO.wineExists(), is(true));

        sleep(3);
    }

    public void checkComponents() {

        for (String comp : COMPONENTS) {

            assertThat("Must " + comp + " not found", mustPO.mustExists(comp), is(true));
        }
    }
}
