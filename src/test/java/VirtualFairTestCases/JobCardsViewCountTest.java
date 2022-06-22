package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class JobCardsViewCountTest extends BaseForVirtualFair {
    @Test //(invocationCount = 10)
    public void jobCardsViewCount(){
        try{
            JavascriptExecutor ex=(JavascriptExecutor)driver;
            WebElement infodeskentrance = wait.until(ExpectedConditions.presenceOfElementLocated(infoBoothEntrance));
            ex.executeScript("arguments[0].click()", infodeskentrance);

            WebElement jobcount = wait.until(ExpectedConditions.presenceOfElementLocated(jobCounter));
            Integer displayedCount = Integer.parseInt(jobcount.getText());

            var firstJobPost = driver.findElement(By.xpath("//div[contains(@class, 'col-md-9')]/div//div[contains(@class, 'col-lg-')]//span//a"));

            var firstJobViewCountWebelement = driver.findElement(By.xpath("//div[contains(@class, 'col-md-9')]/div//div[contains(@class, 'col-lg-')]//div[contains(@class, 'col-xs-3 text-right')]"));

            int firstJobFIRSTViewCount = Integer.parseInt(firstJobViewCountWebelement.getText());

            ex.executeScript("arguments[0].click()", firstJobPost);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'information')]//div[last()-1]")));
            var newViewCountWebelem = driver.findElement(By.xpath("//div[contains(@class, 'information')]//div[last()-1]"));

            int firstJobNEWViewCount = 0;

            String text = newViewCountWebelem.getText().split(" ")[0];

            if (!Objects.equals(text, "Unspecified")){
                firstJobNEWViewCount = Integer.parseInt(text);
            }


            Assert.assertTrue(firstJobNEWViewCount > firstJobFIRSTViewCount);

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
