package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvalidUsernameLoginTest extends BaseForLogin {

    @Test
    public void invalidUsernameLogin(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }
        driver.findElement(loginButton).click();

        driver.findElement(loginEmail).sendKeys(RandomStringUtils.randomAlphabetic(10)); //invalid
        driver.findElement(loginPass).sendKeys(loginpassword); //valid
        driver.findElement(loginSignInButton).click();

        assertEquals(driver.findElements(invalidLogin).size(), 1);
    }
}
