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

    @Test
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

        driver.findElement(loginButton).click();

        driver.findElement(loginEmail).sendKeys(loginmail);
        driver.findElement(loginPass).sendKeys(loginpassword);
        driver.findElement(loginSignInButton).click();

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

            Assert.assertEquals(driver.getCurrentUrl(), url);

            WebElement logoutBut = driver.findElement(logoutButton);
            logoutBut.click();

        }catch (Exception e){
            Assert.fail();
        }
    }

}
