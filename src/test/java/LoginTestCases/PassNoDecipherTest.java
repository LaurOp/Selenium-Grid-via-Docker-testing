package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;

public class PassNoDecipherTest extends BaseForLogin {

    @Test     (groups = "security") //(invocationCount = 5)
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
            String myString = getClipboardString();

            Assert.assertNotEquals(loginpassword, myString);
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

    }



    public static String getClipboardString() {
        try {
            return (String) Toolkit
                    .getDefaultToolkit()
                    .getSystemClipboard()
                    .getData(DataFlavor.stringFlavor);
        } catch (IllegalStateException | HeadlessException | IOException | UnsupportedFlavorException e) {
            e.printStackTrace();
        }
        return null;
    }

}
