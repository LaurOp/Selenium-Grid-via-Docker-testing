package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PassNotInCookiesTest extends BaseForLogin {



    @Test   (groups = "cookies")
    public void passNotInCookies(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }
        catch (Exception ignored){
        }


        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(15, ChronoUnit.SECONDS));

            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            driver.findElement(loginButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail));
            driver.findElement(loginEmail).sendKeys(loginmail);
            driver.findElement(loginPass).sendKeys(loginpassword);
            driver.findElement(loginSignInButton).click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));


            var cookies = driver.manage().getCookies();

            for (Cookie cookie : cookies) {

                if(cookie.getName().contains("pass")){
                    Assert.fail();
                }
                if(cookie.getValue().contains(loginpassword)){
                    Assert.fail();
                }
            }

            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            driver.findElement(logoutButton).click();
        }catch (Exception e){
            Assert.fail();
        }
    }

}
