package Selenium;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateGrapeTest extends SeleniumTestBase {

    public static final String GRAPE_NAME = "sorin7";


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
        clickCrush(GRAPE_NAME);

        sleep(3);
    }

    private void clickCrush(String grapeName) {

        WebElement table = driver.findElement(By.cssSelector("table.App-table tbody"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(0).getText().equals(grapeName)) {
                td.get(4).findElement(By.tagName("button")).click();
                break;
            }
        }
    }


}
