package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ForgotPassOpensTest extends BaseForLogin
{

    @Test
    public void forgotPassOpens(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        driver.findElement(loginButton).click();

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

            WebElement forgotLink = driver.findElement(loginForgot);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forgotLink);
            forgotLink.click();

            System.out.println("Forgot password clicked");

            WebElement resetPassText = driver.findElement(By.xpath("//h1[text()='Recover your password']"));
            wait.until(ExpectedConditions.visibilityOf(resetPassText));

            WebElement emailTextBox = driver.findElement(with(By.xpath("//input[@placeholder='Email']")).below(resetPassText));

            driver.findElement(By.xpath("//span[contains(@class,'close-button')]")).click();
        }catch (Exception e){
            Assert.fail();
        }
    }
}
