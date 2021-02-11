package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTestBase {

    protected static WebDriver driver;


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

    public static void waitForElementToBeVisible(By by) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
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

    public static void select(By by, String option) {

        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(option);
    }

}
