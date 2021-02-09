package Selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSelenium {

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
        // driver.findElement(By.cssSelector("button.animated-button")).click();
        // driver.findElement(By.linkText("Add grapes")).click();

        driver.findElement(By.id("name")).sendKeys("Denisa Pîntea");

        // driver.findElement(By.xpath("//label[contains(text(),'Quantity:')]"))
        Select select = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
        select.selectByVisibleText("36");

        driver.findElement(By.id("age")).sendKeys("50");
        driver.findElement(By.id("ripeness")).sendKeys("91");

        driver.findElement(By.cssSelector("input[type='submit']")).click();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

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
