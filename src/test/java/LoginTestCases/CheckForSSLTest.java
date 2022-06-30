package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckForSSLTest extends BaseForLogin {

    @Test   (groups = "security")
    public void checkForSSLCertificate(){
        // SSL certificate would pop up in the browser, so we need to check if it's there
        try{
            driver.get(url);
            try{
                driver.findElement(logoutButton).click();
            }
            catch (Exception ignored){
            }

            driver.findElement(loginButton).click();
            assertEquals(driver.getTitle(), "Careers In White");
        }catch (Exception e){
            Assert.fail();
        }

    }

}
