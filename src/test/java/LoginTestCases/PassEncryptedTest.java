package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PassEncryptedTest extends BaseForLogin {

    @Test   (groups = "security")
    public void passEncrypted(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();

        WebElement passField = driver.findElement(loginPass);
        Assert.assertEquals(passField.getAttribute("type"), "password");

    }

}
