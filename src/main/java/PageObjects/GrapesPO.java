package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GrapesPO {

    WebDriver driver;

    private boolean successAddGrapes = false;

    public GrapesPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSuccessAddGrapes() {
        return successAddGrapes;
    }

    public void setSuccessAddGrapes() {
        successAddGrapes = true;
    }

    public void resetSuccessAddGrapes() {
        successAddGrapes = false;
    }

    public void clickCrush(String grapeName) {

        WebElement table = driver.findElement(By.cssSelector("table.App-table tbody"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(0).getText().equals(grapeName)) {
                setSuccessAddGrapes();
                td.get(4).findElement(By.tagName("button")).click();
                break;
            }
        }
    }
}
