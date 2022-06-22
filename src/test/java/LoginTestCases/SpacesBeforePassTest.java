package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SpacesBeforePassTest extends BaseForLogin {

    @Test
    public void spacesBeforePass() {
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        driver.findElement(loginButton).click();

        var spaces = new String(new char[10]).replace("\0", " ");

        driver.findElement(loginPass).sendKeys(spaces);

        var whatsCopied = driver.findElement(loginPass).getAttribute("value");

        assertEquals(whatsCopied.length(), 0);   // !! should be 1

    }
}
