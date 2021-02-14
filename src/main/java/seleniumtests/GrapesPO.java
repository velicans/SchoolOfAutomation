package seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class GrapesPO {
    static WebDriver driver;
    static WebDriverWait wait;

    final String GRAPE_NAME;
    final String GRAPE_QUANTITY;
    final String GRAPE_AGE;
    final String GRAPE_RIPENESS;


    GrapesPO(String name, String quantity, String age, String ripeness) {
        GRAPE_NAME = name;
        GRAPE_QUANTITY = quantity;
        GRAPE_AGE = age;
        GRAPE_RIPENESS = ripeness;

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://wineappui.azurewebsites.net");

        wait = new WebDriverWait(driver, 3);

    }

    public void addGrape(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add grapes')]")));

        driver.findElement(By.cssSelector(".animated-button")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys(GRAPE_NAME);
        Select select = new Select(driver.findElement(By.cssSelector("#quantity")));
        select.selectByVisibleText(GRAPE_QUANTITY);
        driver.findElement(By.id("age")).sendKeys(GRAPE_AGE);
        driver.findElement(By.id("ripeness")).sendKeys(GRAPE_RIPENESS);
        driver.findElement(By.cssSelector(".add-grapes-form > input:nth-child(11)")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".App-table")));
        checkIfGrapeAdded();


    }

    public void checkIfGrapeAdded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add grapes')]")));

        WebElement table = driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        boolean checkAdded=false;
        for (WebElement row:rows){
            List<WebElement> td  = row.findElements(By.tagName("td"));
            if (td.get(0).getText().equals(GRAPE_NAME)){
                checkAdded=true;
                break;
            }
        }

        assertThat(checkAdded,is(true));
    }

    public void crushGrapes(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add grapes')]")));

        WebElement table = driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        boolean checkButton=false;
        for (WebElement row:rows){
            List<WebElement> td  = row.findElements(By.tagName("td"));
            if (td.get(0).getText().equals(GRAPE_NAME)){
                td.get(4).findElement(By.tagName("button")).click();
                checkButton=true;
                break;
            }
        }

        assertThat(checkButton,is(true));
    }

    public void closeDriver(){
        driver.close();
        System.out.println("Driver closed on Grape PO");
    }


}
