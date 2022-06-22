package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginContainsAllFieldsTest extends BaseForLogin {

    @Test
    public void loginContainsAllFields() throws InterruptedException{
        driver.get(url);

        driver.findElement(loginButton).click();


        try{
             driver.findElement(loginEmail);
             driver.findElement(loginPass);
             driver.findElement(loginSignInButton);
            // remember = driver.findElement(loginRemember);
             driver.findElement(loginForgot);
             driver.findElement(loginCreate);
        }
        catch (Exception e) {
            Assert.fail();
        }

    }

}
