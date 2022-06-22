package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InvalidPassLoginTest extends BaseForLogin {

    @Test
    public void invalidPassLogin(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }
        driver.findElement(loginButton).click();

        driver.findElement(loginEmail).sendKeys(loginmail); //valid
        driver.findElement(loginPass).sendKeys(RandomStringUtils.randomAlphabetic(10)); //invalid
        driver.findElement(loginSignInButton).click();

        assertEquals(driver.findElements(invalidLogin).size(), 1);
    }


}
