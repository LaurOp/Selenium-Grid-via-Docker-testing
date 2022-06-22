package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class TimeTakenToLogInTest extends BaseForLogin {

    @Test
    public void timeTakentoLogIn(){
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        driver.findElement(loginButton).click();

        driver.findElement(loginEmail).sendKeys(loginmail);
        driver.findElement(loginPass).sendKeys(loginpassword);

        long startTime = System.currentTimeMillis();
        driver.findElement(loginSignInButton).click();



        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body")));

            long endTime = System.currentTimeMillis();
            double totalTime = (double) (endTime - startTime) / 1000;

            System.out.println("Time taken to log in: " +  totalTime + " seconds");

            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            driver.findElement(logoutButton).click();

            Assert.assertTrue(totalTime < 3000);


        }catch (Exception ignored){
            Assert.fail();
        }

    }
}
