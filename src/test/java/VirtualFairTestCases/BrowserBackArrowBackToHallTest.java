package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserBackArrowBackToHallTest extends BaseForVirtualFair {

    @Test //(invocationCount = 10)
    public void browserBackArrow(){

        try{
            JavascriptExecutor ex=(JavascriptExecutor)driver;
            WebElement conf = wait.until(ExpectedConditions.presenceOfElementLocated(conferenceHallEntrance));
            ex.executeScript("arguments[0].click()", conf);

            driver.navigate().back();
            Assert.assertTrue(driver.getCurrentUrl().contains("/virtualfair/hall"));

            WebElement jobsBooth = wait.until(ExpectedConditions.presenceOfElementLocated(jobsHallEntrance));
            ex.executeScript("arguments[0].click()", jobsBooth);

            driver.navigate().back();
            Assert.assertTrue(driver.getCurrentUrl().contains("/virtualfair/hall"));

            WebElement infodeskentrance = wait.until(ExpectedConditions.presenceOfElementLocated(infoBoothEntrance));
            ex.executeScript("arguments[0].click()", infodeskentrance);


            driver.navigate().back();
            Assert.assertTrue(driver.getCurrentUrl().contains("/virtualfair/hall"));
        }
        catch (Exception e){
            Assert.fail();
        }
    }
}
