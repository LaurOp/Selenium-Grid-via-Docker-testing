package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InfoBoothRedirectsTest extends BaseForVirtualFair {

    @Test
    public void infoBoothRedirectsTest() {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='virtualFairBase']")));
            driver.findElement(infoBoothEntrance).click();
            wait.until(ExpectedConditions.urlContains("infoDesk"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();

        }
    }
}

