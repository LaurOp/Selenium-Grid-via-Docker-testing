package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class CreateAccRedirectsTest extends BaseForLogin {


    @Test
    public void createAccRedirects(){
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='cookieBtn']")));
            driver.findElement(By.xpath("//button[@class='cookieBtn']")).click();
        }catch (Exception e){
        }

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            driver.findElement(loginButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginCreate));
            driver.findElement(loginCreate).click();

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }

        try{
            wait = new WebDriverWait(driver, Duration.of(3, ChronoUnit.SECONDS));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='simplert text-info simplert--shown']//button[@class='simplert__close ']")));
            driver.findElement(By.xpath("//div[@class='simplert text-info simplert--shown']//button[@class='simplert__close ']")).click();
        }catch (Exception ignored)
        {}

        Assert.assertEquals(driver.getCurrentUrl(), "https://careersinwhite.com/register");
    }

}
