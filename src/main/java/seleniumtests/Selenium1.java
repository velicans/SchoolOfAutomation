package seleniumtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Selenium1 {


    static WebDriver driver;
    static WebDriverWait wait;
    static final String GRAPE_NAME="AlexR final5";


    @BeforeAll
    public static void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.get("http://wineappui.azurewebsites.net");
        wait = new WebDriverWait(driver, 5);



    }

@Test
@Disabled
@DisplayName("testing stuff in wines")
public void testingStuffInWines(){


    WebElement table;
    List<WebElement> rows;


    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add grapes')]")));
    driver.findElement(By.xpath("/html/body/div/div/header/nav/a[4]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/section/h3")));

    table=driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
    rows = table.findElements(By.tagName("tr"));



    for(WebElement row : rows){
        List<WebElement> td = row.findElements(By.tagName("td"));

        if (td.get(0).getText().equals(GRAPE_NAME)){
            td.get(3).findElement(By.tagName("button")).click();
            td.get(3).findElement(By.xpath("//td[contains(text(),'')]/input")).sendKeys("Test");
            td.get(3).findElement(By.tagName("button")).click();

            table=driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
            rows = table.findElements(By.tagName("tr"));


            td.get(4).findElement(By.tagName("button")).click();
            td.get(4).findElement(By.xpath("//td[contains(text(),'')]/input")).sendKeys("5");
            td.get(4).findElement(By.tagName("button")).click();
            break;
        }
    }
}
    @Test
    @Disabled
    @DisplayName("testing stuff")
    public void test1(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add grapes')]")));
        driver.findElement(By.xpath("/html/body/div/div/header/nav/a[3]")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/section/table")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".App-table")));

       WebElement table;
       List<WebElement> rows;
//

//
//
//        for(WebElement row : rows){
//            List<WebElement> td = row.findElements(By.tagName("td"));
//            System.out.println(row);
//            if (td.get(0).getText().equals(GRAPE_NAME)){
//                td.get(4).findElement(By.tagName("button")).click();
//                System.out.println("Found button");
//                break;
//            }
//        }

        table=driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        rows = table.findElements(By.tagName("tr"));


        for(WebElement row : rows){
            List<WebElement> td = row.findElements(By.tagName("td"));
            if (td.get(1).getText().equals(GRAPE_NAME)){
                System.out.println(td.get(2).getText());
                td.get(0).findElement(By.xpath("//td[contains(text(),'"+GRAPE_NAME+"')]/preceding-sibling::td/input[@type='checkbox']")).click();//.findElement(By.xpath("//input[@type='checkbox']"))
                try{
                    wait(2000);
                }
                catch (InterruptedException e){

                }
                break;
            }
        }

//        boolean findButtonFerment=false;
//        for(WebElement row : rows){
//            List<WebElement> td = row.findElements(By.tagName("td"));
//            if (td.get(1).getText().equals(GRAPE_NAME)){
//                if(td.get(0).findElement(By.xpath("//input[@type='checkbox']"))!=null){
//                    System.out.println("button found");
//                }
//                findButtonFerment=true;
//                break;
//            }
//        }
//
//        Assert.assertTrue("Button not found",findButtonFerment);
//        driver.findElement(By.xpath("/html/body/div/div/header/nav/a[4]")).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/section/h3")));
//        Assert.assertNotNull(driver.findElement(By.xpath("//*[text()='"+GRAPE_NAME+"']")));
    }






    @Test
    @DisplayName("full grape test")
    public void grapeTest() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add grapes')]")));
        boolean findButtonCrush=false;
        boolean findButtonFerment=false;
        WebElement table = driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));


        //Add new grape
        driver.findElement(By.cssSelector(".animated-button")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys(GRAPE_NAME);
        Select select = new Select(driver.findElement(By.cssSelector("#quantity")));
        select.selectByVisibleText("24");
        driver.findElement(By.id("age")).sendKeys("25");
        driver.findElement(By.id("ripeness")).sendKeys("99");
        driver.findElement(By.cssSelector(".add-grapes-form > input:nth-child(11)")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".App-table")));


        table = driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        rows = table.findElements(By.tagName("tr"));

        for(WebElement row : rows){
            List<WebElement> td = row.findElements(By.tagName("td"));
            if (td.get(0).getText().equals(GRAPE_NAME)){
                td.get(4).findElement(By.tagName("button")).click();
                findButtonCrush=true;
                break;
            }
        }



        //Check if grapes can be crushed
        Assert.assertTrue("Button not found",findButtonCrush);



        //Ferment must
        driver.findElement(By.xpath("/html/body/div/div/header/nav/a[3]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".App-table")));

        table=driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        rows = table.findElements(By.tagName("tr"));


        for(WebElement row : rows){
            List<WebElement> td = row.findElements(By.tagName("td"));
            if (td.get(1).getText().equals(GRAPE_NAME)){
                td.get(0).findElement(By.xpath("//td[contains(text(),'"+GRAPE_NAME+"')]/preceding-sibling::td/input[@type='checkbox']")).click();
                findButtonFerment=true;
                break;
            }
        }


        //Check if can ferment
        Assert.assertTrue("Button not found",findButtonFerment);


        driver.findElement(By.cssSelector(".App-page > button:nth-child(5)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/section/h3")));

        try {
            driver.findElement(By.xpath("//*[text()='" + GRAPE_NAME + "']"));
        }
        catch (Exception e){
            Assert.fail("Wine not found");
        }




        //Test set name/ set bottlingVolume
        table=driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        rows = table.findElements(By.tagName("tr"));


        for(WebElement row : rows){
            List<WebElement> td = row.findElements(By.tagName("td"));

            if (td.get(0).getText().equals(GRAPE_NAME)){
                td.get(3).findElement(By.tagName("button")).click();
                td.get(3).findElement(By.xpath("//td[contains(text(),'')]/input")).sendKeys("Test");
                td.get(3).findElement(By.tagName("button")).click();
                break;
            }
        }

        table=driver.findElement(By.xpath("/html/body/div/div/section/table/tbody"));
        rows = table.findElements(By.tagName("tr"));

        for(WebElement row : rows) {
            List<WebElement> td = row.findElements(By.tagName("td"));
            td.get(4).findElement(By.tagName("button")).click();
            td.get(4).findElement(By.xpath("//td[contains(text(),'')]/input")).sendKeys("5");
            td.get(4).findElement(By.tagName("button")).click();
            break;
        }




        }

    @AfterAll
    public static void stopBrowser() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}