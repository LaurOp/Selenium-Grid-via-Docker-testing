package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BackButtonLogoutTest extends BaseForLogin {

    @Test //(invocationCount = 10)
    public void backButtonLogout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));

        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            driver.findElement(loginButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail));
            driver.findElement(loginEmail).sendKeys(loginmail);
            driver.findElement(loginPass).sendKeys(loginpassword);
            wait.until(ExpectedConditions.elementToBeClickable(loginSignInButton));
            driver.findElement(loginSignInButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            driver.findElement(logoutButton).click();

            driver.navigate().back();
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }


        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(logoutButton));

        }
        catch (Exception ignored){Assert.fail();}

    }
}
