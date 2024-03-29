package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LoginRedirectsHomeTest extends BaseForLogin {

    @Test   (groups = "redirects")
    public void loginRedirectHome(){
        driver.get(url);

        try{
            driver.findElement(By.xpath("//button[@class='cookieBtn']")).click();
        }catch (Exception e){
        }

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }



        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));


            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            driver.findElement(loginButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail));
            driver.findElement(loginEmail).sendKeys(loginmail);
            driver.findElement(loginPass).sendKeys(loginpassword);
            driver.findElement(loginSignInButton).click();


            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

            Assert.assertEquals(driver.getCurrentUrl(), url);

            WebElement logoutBut = driver.findElement(logoutButton);
            logoutBut.click();

        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

}
