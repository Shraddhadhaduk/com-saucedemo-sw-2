package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
      //find username field and enter valid username
       driver.findElement(By.id("user-name")).sendKeys("standard_user");

      //find password field and enter valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

      //find login button and click on it
      driver.findElement(By.name("login-button")).click();

      //verify text
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //find username field and enter valid username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //find password field and enter valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //find login button and click on it
        driver.findElement(By.name("login-button")).click();

        //verify that six products are displayed
         int productCount = driver.findElements(By.className("inventory_item_name")).size();
         Assert.assertEquals(productCount, 6);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
