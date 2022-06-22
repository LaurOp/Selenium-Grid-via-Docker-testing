package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.testng.Assert.assertEquals;

public class TabFunctionalityTest extends BaseForLogin {

    @Test
    public void tabFunctionality(){
        driver.get(url);
        driver.findElement(loginButton).click();

        WebElement emailTextbox = driver.findElement(loginEmail);
        WebElement passTextbox = driver.findElement(loginPass);

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(2, ChronoUnit.SECONDS));

        try{
            wait.until(ExpectedConditions.visibilityOf(emailTextbox));
            emailTextbox.click();
            emailTextbox.sendKeys(Keys.TAB);
        }
        catch (Exception e){
            Assert.fail();
        }

        assertEquals(driver.switchTo().activeElement(), passTextbox);
    }
}
