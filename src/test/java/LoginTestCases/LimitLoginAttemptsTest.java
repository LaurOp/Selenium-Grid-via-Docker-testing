package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LimitLoginAttemptsTest extends BaseForLogin {

    @Test   (groups = "security")
    public void limitLoginAttempts(){   // let's say the limit is 15 unsuccessfuls in a row
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        driver.findElement(loginButton).click();

        driver.findElement(loginEmail).sendKeys(RandomStringUtils.randomAlphabetic(15));
        driver.findElement(loginPass).sendKeys("abc12345");

        WebElement buton = driver.findElement(loginSignInButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));

        Boolean b = false;

        for(int i=0; i<15; i++) {
            try {
                JavascriptExecutor ex=(JavascriptExecutor)driver;
                ex.executeScript("arguments[0].click()", buton);
            } catch (Exception e) {
                System.out.println(e);
                b = true;
                break;
            }
        }

        if (b.equals(false)){
            Assert.fail();
        }
    }
}
