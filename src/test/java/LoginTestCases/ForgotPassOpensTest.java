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

    @Test   (groups = "redirects")
    public void forgotPassOpens(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }


        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            driver.findElement(loginButton).click();

            System.out.println(1);

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginForgot));
            WebElement forgotLink = driver.findElement(loginForgot);

            System.out.println(2);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forgotLink);

            JavascriptExecutor ex=(JavascriptExecutor)driver;
            ex.executeScript("arguments[0].click()", forgotLink);

            System.out.println(3);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Recover your password']")));
            //WebElement emailTextBox = driver.findElement(with(By.xpath("//input[@placeholder='Email']")).below(resetPassText));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'close-button')]")));
            driver.findElement(By.xpath("//span[contains(@class,'close-button')]")).click();
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
