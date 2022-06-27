package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class CookiesClearedAskCredentialsTest extends BaseForLogin {

    @Test
    public void cookiesClearedAskCredentials() throws InterruptedException {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

        try{
            driver.findElement(logoutButton).click();
        }
        catch (Exception ignored){
        }

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            driver.findElement(loginButton).click();

            driver.findElement(loginEmail).sendKeys(loginmail);
            driver.findElement(loginPass).sendKeys(loginpassword);
            driver.findElement(loginSignInButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

            driver.manage().deleteAllCookies();

            driver.navigate().to("https://careersinwhite.com/Inbox/");

        }
        catch (Exception e){
            Assert.fail();
        }
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        }
        catch (Exception ignored){
            Assert.fail();

            try{
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='menu hidden-sm hidden-xs']//a[text()='Logout']")));
                driver.findElement(By.xpath("//ul[@class='menu hidden-sm hidden-xs']//a[text()='Logout']")).click();
            }
            catch (Exception ignored2){}
        }
    }

}
