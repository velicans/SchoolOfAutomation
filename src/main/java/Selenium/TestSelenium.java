package Selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSelenium {

    WebDriver driver;


    public static void main(String[] args) {

        WebDriver driver;

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = setOptions();

        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
