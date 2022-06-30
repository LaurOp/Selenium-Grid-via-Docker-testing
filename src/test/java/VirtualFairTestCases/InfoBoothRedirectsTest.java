package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InfoBoothRedirectsTest extends BaseForVirtualFair {

    @Test   (dependsOnGroups = "virtualfairFirsts")//(invocationCount = 5)
    public void infoBoothRedirectsTest() {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='virtualFairBase']")));

            WebElement inf = driver.findElement(infoBoothEntrance);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click()", inf);

            wait.until(ExpectedConditions.urlContains("infoDesk"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();

        }
    }
}

