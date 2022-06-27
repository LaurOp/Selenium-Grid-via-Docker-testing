package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LogoutRedirectToHomeTest extends BaseForLogin {


    @Test
    public void logoutRedirectToHome(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }



        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            driver.findElement(loginButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail));
            driver.findElement(loginEmail).sendKeys(loginmail);
            driver.findElement(loginPass).sendKeys(loginpassword);
            driver.findElement(loginSignInButton).click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

            WebElement logoutBut = driver.findElement(logoutButton);
            var logoutRedirectsTo = logoutBut.getAttribute("href");

            Assert.assertEquals(logoutRedirectsTo, url);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }
}
