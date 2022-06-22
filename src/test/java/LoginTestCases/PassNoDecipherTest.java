package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.util.Arrays;

public class PassNoDecipherTest extends BaseForLogin {

    @Test
    public void passNoDecipher(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        driver.findElement(loginButton).click();

        driver.findElement(loginEmail).sendKeys("abc", Keys.chord(Keys.CONTROL, "a"),Keys.chord(Keys.CONTROL,"c"),Keys.DELETE);
        driver.findElement(loginPass).sendKeys(loginpassword, Keys.chord(Keys.CONTROL, "a"),Keys.chord(Keys.CONTROL,"c"));

        try{
            String myString = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

            Assert.assertNotEquals(loginpassword, myString);
        }
        catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            Assert.fail();
        }

    }
}
