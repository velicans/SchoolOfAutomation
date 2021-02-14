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

public class WinesPO {
    WebDriver driver;
    WebDriverWait wait;

    final String GRAPE_NAME;

    WinesPO(String name) {
        GRAPE_NAME = name;

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://wineappui.azurewebsites.net");

        wait = new WebDriverWait(driver, 3);
    }

    public void goToWines() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/header/nav/a[4]")));
        driver.findElement(By.xpath("/html/body/div/div/header/nav/a[4]")).click();

    }

    public void findWine() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".App-table")));
        WebElement table = driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        boolean findWineInTable = false;
        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));
            if (td.get(0).getText().equals(GRAPE_NAME)) {
                findWineInTable = true;
                break;
            }
        }

        assertThat(findWineInTable, is(true));
    }

    public void setName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".App-table")));
        WebElement table = driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        boolean clickedNameButton = false;
        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(0).getText().equals(GRAPE_NAME)) {
                td.get(3).findElement(By.tagName("button")).click();
                td.get(3).findElement(By.xpath("//td[contains(text(),'')]/input")).sendKeys("Test");
                td.get(3).findElement(By.tagName("button")).click();
                clickedNameButton = true;
                break;
            }
        }

        assertThat(clickedNameButton, is(true));

    }

    public void setBottlingVolume() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".App-table")));
        WebElement table = driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        boolean clickedBottleVolume = false;
        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));
            td.get(4).findElement(By.tagName("button")).click();
            td.get(4).findElement(By.xpath("//td[contains(text(),'')]/input")).sendKeys("5");
            td.get(4).findElement(By.tagName("button")).click();
            clickedBottleVolume = true;
            break;
        }

        assertThat(clickedBottleVolume, is(true));

    }

    public void closeDriver() {
        driver.close();
        System.out.println("Driver closed in WinesPO");
    }


}
