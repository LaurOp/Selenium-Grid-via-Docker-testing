package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class ChatRestrictedToLoggedInTest extends BaseForVirtualFair {

    @Test //(invocationCount = 5)
    public void chatRestrictedToLoggedInTest(){


        try{
            JavascriptExecutor ex=(JavascriptExecutor)driver;

            WebElement infoBooth = wait.until(ExpectedConditions.presenceOfElementLocated(infoBoothEntrance));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", infoBooth);
            ex.executeScript("arguments[0].click()", infoBooth);

            WebElement chat = wait.until(ExpectedConditions.presenceOfElementLocated(chatInfoDesk));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chat);
            ex.executeScript("arguments[0].click()", chat);

            sleep(100);
            Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        }
        catch (Exception e){
            System.out.println(e);
            Assert.fail();
        }
    }
}
