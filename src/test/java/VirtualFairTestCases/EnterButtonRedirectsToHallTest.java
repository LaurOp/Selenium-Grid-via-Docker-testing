package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnterButtonRedirectsToHallTest extends BaseForVirtualFair {

    @Test   (groups = "virtualfairFirsts", alwaysRun = true)
    public void enterButtonRedirectsToHallTest() {

        try {
            wait.until(ExpectedConditions.urlContains("virtualfair/hall"));
        }
        catch (Exception e){
            Assert.fail();
        }
    }
}
