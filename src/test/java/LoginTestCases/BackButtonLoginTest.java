package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BackButtonLoginTest extends BaseForLogin {


    @Test   //(invocationCount = 10)
    public void backButtonLogin(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();

        driver.findElement(loginEmail).sendKeys(loginmail);
        driver.findElement(loginPass).sendKeys(loginpassword);
        driver.findElement(loginSignInButton).click();


        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

            //driver.navigate().back();
            driver.navigate().to(url);  // browser redirect instead of back button

            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            driver.findElement(logoutButton).click();
        }catch (Exception e){
            Assert.fail();
        }
    }
}
