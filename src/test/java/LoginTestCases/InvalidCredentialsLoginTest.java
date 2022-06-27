package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.testng.Assert.assertEquals;

public class InvalidCredentialsLoginTest extends BaseForLogin {

    @Test
    public void invalidCredentialsLogin(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            driver.findElement(loginButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail));
            driver.findElement(loginEmail).sendKeys(RandomStringUtils.randomAlphabetic(15)); // invalid
            driver.findElement(loginPass).sendKeys(RandomStringUtils.randomAlphabetic(15)); // invalid
            driver.findElement(loginSignInButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLogin));
            assertEquals(driver.findElements(invalidLogin).size(), 1);
        }
        catch (Exception e){
            Assert.fail();
        }

    }
}
