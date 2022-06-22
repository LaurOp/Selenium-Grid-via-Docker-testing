package VirtualFairTestCases;

import BaseClasses.BaseForVirtualFair;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class JobCounterWorksTest extends BaseForVirtualFair {

    @Test //(invocationCount = 10)
    public void jobCounterWorks(){

        try{
            JavascriptExecutor ex=(JavascriptExecutor)driver;
            WebElement infodeskentrance = wait.until(ExpectedConditions.presenceOfElementLocated(infoBoothEntrance));
            ex.executeScript("arguments[0].click()", infodeskentrance);

            WebElement jobcount = wait.until(ExpectedConditions.presenceOfElementLocated(jobCounter));
            Integer displayedCount = Integer.parseInt(jobcount.getText());

            var jobPosts = driver.findElements(By.xpath("//div[contains(@class, 'col-md-9')]/div//div[contains(@class, 'col-lg-')]"));

            int actualCount = 0;


            WebElement lastJobsPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'icon-angle-double-right')]/..")));

            WebElement lastPage = null;
            int indexLastPage = 1;
            int nrOfElemsLastPage = 0;

            if(!lastJobsPage.getAttribute("class").contains("disabled")){
                ex.executeScript("arguments[0].click()", lastJobsPage);

                lastPage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'paging-holder')]/div[last()-2]")));

                wait.until(ExpectedConditions.attributeContains(lastPage, "class","active"));
                indexLastPage = Integer.parseInt(lastPage.getText());

                nrOfElemsLastPage = driver.findElements(By.xpath("//div[contains(@class, 'col-md-9')]/div//div[contains(@class, 'col-lg-')]")).size();

            }

            actualCount = (indexLastPage - 1) * jobPosts.size() + nrOfElemsLastPage;


//            System.out.println(actualCount);
//            System.out.println(indexLastPage );
//            System.out.println(jobPosts.size());
//            System.out.println(nrOfElemsLastPage);

            Assert.assertEquals(displayedCount, actualCount);

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
