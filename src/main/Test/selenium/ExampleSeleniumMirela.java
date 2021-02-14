package selenium;

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

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExampleSeleniumMirela {

    public static final String GRAPE_NAME = "mirela";
    private static WebDriver driver;

    @BeforeAll
    public static void before() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(setOptions());
        driver.get("https://wineappui.azurewebsites.net/");

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

    @Test
    @Order(1)
    public void grapeTest() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add grapes')]")));

        driver.findElement(By.xpath("//button[contains(text(),'Add grapes')]")).click();
        // driver.findElement(By.cssSelector("button.animated-button")).click();
        // driver.findElement(By.linkText("Add grapes")).click();

        driver.findElement(By.id("name")).sendKeys(GRAPE_NAME);

        // driver.findElement(By.xpath("//label[contains(text(),'Quantity:')]"))
        Select select = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
        select.selectByVisibleText("24");

        driver.findElement(By.id("age")).sendKeys("2");
        driver.findElement(By.id("ripeness")).sendKeys("90");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.App-table tbody")));

        WebElement table = driver.findElement(By.cssSelector("table.App-table tbody"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        boolean grapeAdded = false;
        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(0).getText().equals(GRAPE_NAME)) {
                grapeAdded = true;
                td.get(4).findElement(By.tagName("button")).click();
                break;
            }
        }
        Assertions.assertTrue(grapeAdded, "Grape was not added");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    public void testMustTable() {
        driver.findElement(By.linkText("Must")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                "body:nth-child(2) div:nth-child(2) div.App section.App-page > table.App-table:nth-child(3)")));
        WebElement table = driver.findElement(By.tagName("table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        boolean mustAdded = false;
        for (WebElement row : rows) {
            String rowText = row.getText();
            if (rowText.startsWith(GRAPE_NAME)) {
                mustAdded = true;
                row.findElement(By.tagName("input")).click();
                driver.findElement(By.tagName("button")).click();
            }
        }
        Assertions.assertTrue(mustAdded, "Must was not added");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(3)
    public void testWineTable() {
        driver.findElement(By.linkText("Wines")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table")));

        WebElement table = driver.findElement(By.tagName("table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        boolean wineAdded = false;
        for (WebElement row : rows) {
            String preview = row.getText();
            if (preview.startsWith(GRAPE_NAME)) {
                wineAdded = true;
            }
        }

        Assertions.assertTrue(wineAdded, "Wine was not added");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
