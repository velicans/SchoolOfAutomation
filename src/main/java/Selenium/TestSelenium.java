package Selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestSelenium {

    public static final String GRAPE_NAME = "Andrei Stoian";
    private static WebDriver driver;

    public static ChromeOptions setOptions() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");

        return options;
    }

    @BeforeAll
    public static void before() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(setOptions());

        driver.get("https://wineappui.azurewebsites.net/");

    }

    @Test
    public void grapeTest() {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add grapes')]")));

        driver.findElement(By.xpath("//button[contains(text(),'Add grapes')]")).click();
        // driver.findElement(By.cssSelector("button.animated-button")).click();
        // driver.findElement(By.linkText("Add grapes")).click();

        driver.findElement(By.id("name")).sendKeys(GRAPE_NAME);

        // driver.findElement(By.xpath("//label[contains(text(),'Quantity:')]"))
        Select select = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
        select.selectByVisibleText("24");

        driver.findElement(By.id("age")).sendKeys("97");
        driver.findElement(By.id("ripeness")).sendKeys("97");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.App-table tbody")));

        WebElement table = driver.findElement(By.cssSelector("table.App-table tbody"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if(td.get(0).getText().equals(GRAPE_NAME)) {
                td.get(4).findElement(By.tagName("button")).click();
                Assertions.assertEquals(GRAPE_NAME, td.get(0).getText());
                break;
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Must:')]")));

        WebElement table2 = driver.findElement(By.cssSelector("table.App-table tbody"));

        List<WebElement> rows2 = table2.findElements(By.tagName("tr"));

        for (WebElement row : rows2) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(1).getText().equals(GRAPE_NAME)) {
                td.get(0).findElement(By.tagName("input")).click();
                Assertions.assertEquals(GRAPE_NAME, td.get(1).getText());
                break;
            }
        }

        driver.findElement(By.tagName("button")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Wine cellar contents:')]")));

            WebElement table3 = driver.findElement(By.cssSelector("table.App-table tbody"));

            List<WebElement> rows3 = table3.findElements(By.tagName("tr"));

        for  (WebElement row : rows3) {
            List<WebElement> td = row.findElements(By.tagName("td"));

                if(td.get(0).getText().equals(GRAPE_NAME)) {
                    System.out.println(GRAPE_NAME + " este in lista de vinuri");
                    Assertions.assertEquals(GRAPE_NAME, td.get(0).getText());
                    break;
                }
            }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


            driver.quit();
    }


   /* @AfterAll
    public static void after() {
*/


   // }




}
