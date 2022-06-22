package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FocusedOnUsernameTest extends BaseForLogin {

    @Test
    public void focusedOnUsername() throws InterruptedException {
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        driver.findElement(loginButton).click();


        WebElement textbox = driver.findElement(loginEmail);

        assertEquals(driver.switchTo().activeElement(), textbox);
    }
}
