package PageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MustPO {

    WebDriver driver;
    private StringBuilder composition = new StringBuilder();

    public MustPO(WebDriver driver) {
        this.driver = driver;
    }

    public StringBuilder getComposition() {
        return composition;
    }

    public void setComposition(StringBuilder composition) {
        this.composition = composition;
    }

    public List<String> clickFerment(List<String> components) {

        WebElement table = driver.findElement(By.cssSelector("table.App-table tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (components.contains(td.get(1).getText())) {
                td.get(0).findElement(By.tagName("input")).click();
                Assertions.assertTrue(td.get(0).findElement(By.tagName("input")).isSelected(),
                        "The checkbox for " + td.get(1).getText() + " is not selected");
                getComposition().append(td.get(1).getText());
                getComposition().append(", ");
                components.remove(td.get(1).getText());
            }
        }
        setComposition(new StringBuilder(getComposition().substring(0, getComposition().length() - 2)));
        return components;
    }

    public boolean mustExists(String name) {

        WebElement table = driver.findElement(By.cssSelector("table.App-table tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(1).getText().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
