package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PassCopyPastedTest extends BaseForLogin {

    @Test
    public void passCopyPasted(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));


        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail));
        driver.findElement(loginEmail).sendKeys(loginpassword, Keys.chord(Keys.CONTROL, "a"),Keys.chord(Keys.CONTROL,"c"),Keys.DELETE);
        driver.findElement(loginEmail).sendKeys(loginmail);
        driver.findElement(loginPass).sendKeys(Keys.chord(Keys.CONTROL, "v"));

        driver.findElement(loginSignInButton).click();


        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

            driver.findElement(logoutButton).click();
        }catch (Exception e){
            Assert.fail();
        }

    }
}
