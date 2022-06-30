package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.testng.Assert.assertTrue;

public class ValidPlaceholdersTest extends BaseForLogin {

    @Test   (groups = "UI")
    public void validPlaceholders(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();

        WebElement user, pass;
        user = driver.findElement(loginEmail);
        pass = driver.findElement(loginPass);

        String userPlaceholder = user.getAttribute("placeholder");
        String passPlaceholder = pass.getAttribute("placeholder");

        assertTrue(userPlaceholder.toLowerCase().contains("email"));
        assertTrue(passPlaceholder.toLowerCase().contains("pass"));

    }

}
