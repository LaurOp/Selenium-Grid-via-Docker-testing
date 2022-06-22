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



    @Test
    public void passNotInCookies(){
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

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
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

            driver.findElement(logoutButton).click();
        }catch (Exception e){
            Assert.fail();
        }
    }

}
