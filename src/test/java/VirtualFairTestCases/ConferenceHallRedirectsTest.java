package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConferenceHallRedirectsTest extends BaseForVirtualFair {

    @Test   (dependsOnGroups = "virtualfairFirsts")
    public void conferenceHallRedirectsTest() {

        try {
            JavascriptExecutor ex=(JavascriptExecutor)driver;
            WebElement conference = wait.until(ExpectedConditions.presenceOfElementLocated(conferenceHallEntrance));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", conference);
            ex.executeScript("arguments[0].click()", conference);

            wait.until(ExpectedConditions.urlContains("amphitheater"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();

        }
    }
}
