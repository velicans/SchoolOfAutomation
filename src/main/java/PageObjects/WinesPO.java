package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WinesPO {

    WebDriver driver;
    private boolean wineExists = false;
    private boolean okChangeName = false;
    private boolean okChangeBottling = false;
    private final int nameColumnID = 3;
    private final int bottlingColumnID = 4;

    public WinesPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean wineExists() {
        return wineExists;
    }

    public void setWineExists() {
        wineExists = true;
    }

    public void resetWineExists() {
        wineExists = false;
    }

    public boolean okChangeName() {
        return okChangeName;
    }

    public void setOkChangeName() {
        okChangeName = true;
    }

    public void resetOkChangeName() {
        okChangeName = false;
    }

    public boolean okChangeBottling() {
        return okChangeBottling;
    }

    public void setOkChangeBottling() {
        okChangeBottling = true;
    }

    public void resetOkChangeBottling() {
        okChangeBottling = false;
    }

    public void checkWine(String composition) {

        resetWineExists();

        WebElement table = driver.findElement(By.cssSelector("table.App-table tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(0).getText().equals(composition)) {
                setWineExists();
                break;
            }
        }
    }

    public void changeName(String composition, String name) {

        changeByColumn(nameColumnID, composition, name);
    }

    public void changeBottlingVolume(String composition, String bottlingVolume) {

        changeByColumn(bottlingColumnID, composition, bottlingVolume);
    }

    public void changeByColumn(int columnID, String composition, String text) {

        WebElement table = driver.findElement(By.cssSelector("table.App-table tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(0).getText().equals(composition)) {
                td.get(columnID).findElement(By.tagName("button")).click();
                td.get(columnID).findElement(By.tagName("input")).sendKeys(text);
                td.get(columnID).findElement(By.tagName("button")).click();
                if (columnID == nameColumnID)
                    setOkChangeName();
                if (columnID == bottlingColumnID)
                    setOkChangeBottling();
                break;
            }
        }
    }

}
