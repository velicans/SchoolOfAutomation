package Selenium;


import PageObjects.GrapesPO;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CreateGrapeTest extends SeleniumTestBase {

    public static final String GRAPE_NAME = "daniel";

    GrapesPO grapesPO;

    @Test
    public void grapeTest() {

        waitForElementToBeVisible(By.xpath("//button[contains(text(),'Add grapes')]"));

        click(By.xpath("//button[contains(text(),'Add grapes')]"));
        type(By.id("name"), GRAPE_NAME);
        select(By.xpath("//select[@id='quantity']"), "24");
        type(By.id("age"), "99");
        type(By.id("ripeness"), "99");
        click(By.cssSelector("input[type='submit']"));

        waitForElementToBeVisible(By.cssSelector("table.App-table tbody"));

        grapesPO = new GrapesPO(driver);
        grapesPO.clickCrush(GRAPE_NAME);

        sleep(3);
    }


}
