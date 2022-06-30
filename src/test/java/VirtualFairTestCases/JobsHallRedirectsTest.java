package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobsHallRedirectsTest extends BaseForVirtualFair {
    @Test   (dependsOnGroups = "virtualfairFirsts")
    public void jobsHallRedirectsTest() {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='virtualFairBase']")));
            driver.findElement(jobsHallEntrance).click();
            wait.until(ExpectedConditions.urlContains("/floor"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();

        }
    }

}
