package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ValidationMessageDisplayedTest extends BaseForLogin {

    @Test   (groups = "UI")
    public void validationMessageDisplayed(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }
        driver.findElement(loginButton).click();

        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click()", driver.findElement(loginSignInButton));

        assertEquals(driver.findElements(invalidLogin).size(), 1);
    }

}
