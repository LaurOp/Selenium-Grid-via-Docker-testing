package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BlankLoginTest extends BaseForLogin {

    @Test
    public void blankLogin(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        driver.findElement(loginButton).click();

        driver.findElement(loginSignInButton).click();

        assertEquals(driver.findElements(invalidLogin).size(), 1);
    }

}
