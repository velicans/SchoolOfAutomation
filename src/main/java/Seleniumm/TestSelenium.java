package Seleniumm;
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

public class TestSelenium {

    public static final String GRAPE_NAME = "daniel";
    private static WebDriver driver;

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
        driver.findElement(By.id("name")).sendKeys(GRAPE_NAME);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
        select.selectByVisibleText("24");

        driver.findElement(By.id("age")).sendKeys("99");
        driver.findElement(By.id("ripeness")).sendKeys("99");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.App-table tbody")));

        WebElement table = driver.findElement(By.cssSelector("table.App-table tbody"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(0).getText().equals(GRAPE_NAME)) {
                td.get(4).findElement(By.tagName("button")).click();
                break;
            }
        }


// my code

        WebElement lastName = driver.findElement(By.xpath("//tr[last()]/td[1]"));
        System.out.println(lastName.getText());
        Assertions.assertEquals(GRAPE_NAME, lastName.getText(), "check name" );
        sleep(10);
        click(By.xpath("//tr[last()]/td[1]/input[1]"));
        click(By.xpath("//body/div[@id='root']/div[1]/section[1]/button[1]"));
        sleep(5);
        click(By.xpath("//tbody/tr[last()]/td[4]/button[1]"));
        type(By.xpath("//tbody/tr[last()]/td[4]/input[1]"), "De.ala blanao");
        click(By.xpath("//button[contains(text(),'OK')]"));
        click(By.xpath("//tbody/tr[last()]/td[5]/button[1]"));
        type(By.xpath("//tbody/tr[last()]/td[5]/input[1]"), "fara fund");
        click(By.xpath("//button[contains(text(),'OK')]"));

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

    public static void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void click(By by) {

        driver.findElement(by).click();
    }

    public static void type(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }
}
