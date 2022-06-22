package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccRedirectsTest extends BaseForLogin {


    @Test
    public void createAccRedirects(){
        driver.get(url);

        try{
            driver.findElement(logoutButton).click();
        }catch (Exception ignored){
        }

        try{
            driver.findElement(By.xpath("//button[@class='cookieBtn']")).click();
        }catch (Exception e){
        }

        driver.findElement(loginButton).click();

        driver.findElement(loginCreate).click();

        try{
            driver.findElement(By.xpath("//div[@class='simplert text-info simplert--shown']//button[@class='simplert__close ']")).click();
        }catch (Exception ignored)
        {}

        Assert.assertEquals(driver.getCurrentUrl(), "https://careersinwhite.com/register");
    }

}
