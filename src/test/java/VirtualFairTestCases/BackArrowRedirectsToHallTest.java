package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BackArrowRedirectsToHallTest extends BaseForVirtualFair {

    @Test   //(invocationCount = 10)
    public void backArrowIconToHall(){

        try{
            JavascriptExecutor ex=(JavascriptExecutor)driver;
            WebElement conf = wait.until(ExpectedConditions.presenceOfElementLocated(conferenceHallEntrance));
            ex.executeScript("arguments[0].click()", conf);

            driver.findElement(backArrow).click();
            Assert.assertTrue(driver.getCurrentUrl().contains("/virtualfair/hall"));

            WebElement jobsBooth = wait.until(ExpectedConditions.presenceOfElementLocated(jobsHallEntrance));
            ex.executeScript("arguments[0].click()", jobsBooth);

            driver.findElement(backArrow).click();
            Assert.assertTrue(driver.getCurrentUrl().contains("/virtualfair/hall"));

            WebElement infodeskentrance = wait.until(ExpectedConditions.presenceOfElementLocated(infoBoothEntrance));
            ex.executeScript("arguments[0].click()", infodeskentrance);


            driver.findElement(backArrow).click();  // twice cuz it takes you first to jobs expo
            driver.findElement(backArrow).click();
            Assert.assertTrue(driver.getCurrentUrl().contains("/virtualfair/hall"));
        }
        catch (Exception e){
            Assert.fail();
        }

    }
}
