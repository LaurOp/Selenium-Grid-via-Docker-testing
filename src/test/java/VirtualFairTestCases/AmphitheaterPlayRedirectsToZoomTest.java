package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static java.lang.Thread.sleep;

public class AmphitheaterPlayRedirectsToZoomTest extends BaseForVirtualFair {

    @Test   //(invocationCount = 10)
    public void amphitheaterRedirectZoomTest(){
        try{
            String currentHandle = driver.getWindowHandle();

            JavascriptExecutor ex=(JavascriptExecutor)driver;
            WebElement conf = wait.until(ExpectedConditions.presenceOfElementLocated(conferenceHallEntrance));
            ex.executeScript("arguments[0].click()", conf);

            WebElement playConf = wait.until(ExpectedConditions.presenceOfElementLocated(playConference));
            ex.executeScript("arguments[0].click()", playConf);

            Set<String> handles = driver.getWindowHandles();
            for(String handle : handles){
                if(!handle.equalsIgnoreCase(currentHandle)){
                    driver.switchTo().window(handle);
                    break;
                }
            }

            Assert.assertTrue(driver.getCurrentUrl().contains("/zoom"));
            driver.close();
            driver.switchTo().window(currentHandle);
        }
        catch(Exception e){
            Assert.fail();
        }
    }


}
