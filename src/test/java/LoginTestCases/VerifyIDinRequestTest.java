package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class VerifyIDinRequestTest extends BaseForLogin {

    @Test
    public void verifyIDinRequest(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }
        catch (Exception ignored){
        }

        driver.findElement(loginButton).click();

        driver.findElement(loginEmail).sendKeys(loginmail);
        driver.findElement(loginPass).sendKeys(loginpassword);
        driver.findElement(loginSignInButton).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
        try {
            wait.until(ExpectedConditions.urlContains("id="));

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
                driver.findElement(logoutButton).click();
            }
            catch (Exception ignored){}

            Assert.fail();
        }
        catch (Exception ignored){}


        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            driver.findElement(logoutButton).click();
        }
        catch (Exception ignored){}
    }
}
