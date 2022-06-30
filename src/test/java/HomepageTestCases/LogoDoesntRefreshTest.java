package HomepageTestCases;

import BaseClasses.BaseForHomepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoDoesntRefreshTest extends BaseForHomepage {

    @Test   (dependsOnGroups = "homepageFirsts")
    public void logoDoesntRefreshTest() {
        driver.get(url);

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(topLeftLogo));

            WebElement hiddenLink = driver.findElement(By.xpath("//img[@class='logo hidden-xs']/parent::*"));


            Assert.assertEquals(hiddenLink.getAttribute("href"), driver.getCurrentUrl());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}
