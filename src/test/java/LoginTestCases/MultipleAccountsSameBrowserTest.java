package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MultipleAccountsSameBrowserTest extends BaseForLogin {

    @Test
    public void multipleAccountsSameBrowser(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

        driver.get(url);


        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }



        try{

            String originalWindow = driver.getWindowHandle();
            // login first tab
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            driver.findElement(loginButton).click();

            driver.findElement(loginEmail).sendKeys(loginmail);
            driver.findElement(loginPass).sendKeys(loginpassword);
            driver.findElement(loginSignInButton).click();

            // switch tabs
            driver.switchTo().newWindow(WindowType.TAB);

            driver.get(url);
            // logout from second tab if needed
            try{
                driver.findElement(logoutButton).click();
            }catch (Exception ignored){
            }

            // login second tab
            driver.findElement(loginButton).click();

            driver.findElement(loginEmail).sendKeys(loginmail2);
            driver.findElement(loginPass).sendKeys(loginpassword);
            driver.findElement(loginSignInButton).click();

            // go on profile page , second tab
            wait.until(ExpectedConditions.visibilityOfElementLocated(greetings));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modalOuterlay']")));
            driver.findElement(greetings).click();

            // copy current user from localstorage, to compare to first tab
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body")));
            var secondTabUser = ((JavascriptExecutor) driver).executeScript("return localStorage.getItem('User');");


            // swap tabs
            driver.switchTo().window(originalWindow);
            driver.navigate().refresh();

            // go on profile page , first tab
            wait.until(ExpectedConditions.visibilityOfElementLocated(greetings));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modalOuterlay']")));
            driver.findElement(greetings).click();

            // copy current user from localstorage, to compare to second tab
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body")));
            var firstTabUser = ((JavascriptExecutor) driver).executeScript("return localStorage.getItem('User');");


            // compare contents; slice first and last html instructions
            Assert.assertEquals(secondTabUser, firstTabUser);
            // logout; if test succeeded, this logs me out of the second tab too
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            driver.findElement(logoutButton).click();
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }

    }

}
