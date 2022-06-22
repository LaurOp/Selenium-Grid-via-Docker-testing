package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginWorksWithoutCookiesTest extends BaseForLogin {


    @Test
    public void loginWorksWithoutCookies(){
        var options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("network.cookie.cookieBehavior", 2);

        options.setExperimentalOption("prefs", prefs);

        WebDriver driverNoCookies = new ChromeDriver(options);
        driverNoCookies.manage().window().maximize();
        driverNoCookies.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        driverNoCookies.get(url);


        try{
            driverNoCookies.findElement(logoutButton).click();
        }
        catch (Exception ignored){
        }


        var cookies = driver.manage().getCookies();
        if(cookies.size() > 0)
            System.out.println("Cookies found: " + cookies.size());

        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + " : " + cookie.getValue());
        }

        try{
            WebDriverWait wait = new WebDriverWait(driverNoCookies, Duration.of(5, ChronoUnit.SECONDS));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body")));

            driverNoCookies.findElement(loginButton).click();

            driverNoCookies.findElement(loginEmail).sendKeys(loginmail);
            driverNoCookies.findElement(loginPass).sendKeys(loginpassword);
            driverNoCookies.findElement(loginSignInButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            driverNoCookies.findElement(logoutButton).click();

            driverNoCookies.quit();

        }catch (Exception ignored){
            driverNoCookies.quit();
            Assert.fail();
        }


    }

}