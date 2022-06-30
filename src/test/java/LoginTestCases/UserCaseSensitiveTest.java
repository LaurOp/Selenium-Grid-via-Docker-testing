package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static java.lang.Thread.sleep;

public class UserCaseSensitiveTest extends BaseForLogin {



    @Test     (groups = "credentials") //(invocationCount = 5)
    public void userCaseSensitive(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }
        catch (Exception ignored){
        }

        driver.findElement(loginButton).click();

        driver.findElement(loginEmail).sendKeys(loginmail.toUpperCase());
        try{
            sleep(1000);
        }
        catch (Exception ignored){}
        driver.findElement(loginPass).sendKeys(loginpassword);
        driver.findElement(loginSignInButton).click();

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));

            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

            driver.findElement(logoutButton).click();
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }

}
