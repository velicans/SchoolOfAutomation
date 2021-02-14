package seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

public class MustPO {
    static WebDriver driver;
    static WebDriverWait wait;
    final String GRAPE_NAME;

    MustPO(String name) {
        GRAPE_NAME = name;

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://wineappui.azurewebsites.net");

        wait = new WebDriverWait(driver, 3);
    }

    public void goToMust() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/header/nav/a[3]")));
        driver.findElement(By.xpath("/html/body/div/div/header/nav/a[3]")).click();
    }

    public void findMust() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".App-table")));

        WebElement table = driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        boolean findMustElement = false;
        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));
            if (td.get(1).getText().equals(GRAPE_NAME)) {
                findMustElement = true;
                break;
            }
        }

        assertThat(findMustElement, is(true));
    }

    public void fermentMust() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".App-table")));

        WebElement table = driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        boolean findButtonFerment = false;
        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));
            if (td.get(1).getText().equals(GRAPE_NAME)) {
                td.get(0).findElement(By.xpath("//td[contains(text(),'" + GRAPE_NAME + "')]/preceding-sibling::td/input[@type='checkbox']")).click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                findButtonFerment = true;
                break;
            }
        }
        driver.findElement(By.cssSelector(".App-page > button:nth-child(5)")).click();

        assertThat(findButtonFerment, is(true));
    }

    public void closeDriver() {
        driver.close();
        System.out.println("Driver closed on MustPO");
    }
}
