package Selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestSelenium {

    public static final String GRAPE_NAME = "Denisa Pîntea 11";

    public static final String COMPONENT1 = "Denisa Pîntea 8";
    public static final String COMPONENT2 = "Denisa Pîntea 7";
    public static List<String> myComponents = new LinkedList<>(Arrays.asList(GRAPE_NAME));

    private static WebDriver driver;
    private boolean successAddGrapes = false;
    private boolean successFerment = false;

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

        // add grapes
        driver.findElement(By.xpath("//button[contains(text(),'Add grapes')]")).click();

        driver.findElement(By.id("name")).sendKeys(GRAPE_NAME);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
        select.selectByVisibleText("24");

        driver.findElement(By.id("age")).sendKeys("37");
        driver.findElement(By.id("ripeness")).sendKeys("96");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // /grapes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.App-table tbody")));

        WebElement table = driver.findElement(By.cssSelector("table.App-table tbody"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(0).getText().equals(GRAPE_NAME)) {
                successAddGrapes = true;
                td.get(4).findElement(By.tagName("button")).click();
                break;
            }
        }
        Assertions.assertTrue(successAddGrapes, "Something went wrong - " + GRAPE_NAME + " grape not found");

        // /must
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Must:')]")));

        table = driver.findElement(By.cssSelector("table.App-table tbody"));
        rows = table.findElements(By.tagName("tr"));

        StringBuilder composition = new StringBuilder();
        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (myComponents.contains(td.get(1).getText())) {
                td.get(0).findElement(By.tagName("input")).click();
                Assertions.assertTrue(td.get(0).findElement(By.tagName("input")).isSelected(),
                        "The checkbox for " + td.get(1).getText() + " is not selected");
                composition.append(td.get(1).getText());
                composition.append(", ");
                myComponents.remove(td.get(1).getText());
            }
        }
        composition = new StringBuilder(composition.substring(0, composition.length() - 2));

        Assertions.assertTrue(myComponents.isEmpty(), "Could not find all the required components.");
        driver.findElement(By.tagName("button")).click();

        // /wines
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//h3[contains(text(),'Wine cellar contents:')]")));

        table = driver.findElement(By.cssSelector("table.App-table tbody"));
        rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(0).getText().equals(composition.toString())) {
                successFerment = true;
                break;
            }
        }
        Assertions.assertTrue(successFerment,
                "Something went wrong - There is no wine with this composition: " + composition);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterAll
    public static void after() {

        driver.quit();

    }


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

}
