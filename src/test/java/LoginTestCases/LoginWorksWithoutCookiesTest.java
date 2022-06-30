package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginWorksWithoutCookiesTest extends BaseForLogin {


    @Test (groups = "cookies")//(invocationCount = 5)
    public void loginWorksWithoutCookies() throws MalformedURLException {
        var options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("network.cookie.cookieBehavior", 2);

        options.setExperimentalOption("prefs", prefs);

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("browserName", "firefox");
        dc.setCapability("cookieBehavior", 2);

        WebDriver driverNoCookies = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
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

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            driverNoCookies.findElement(loginButton).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail));
            driverNoCookies.findElement(loginEmail).sendKeys(loginmail);
            driverNoCookies.findElement(loginPass).sendKeys(loginpassword);
            driverNoCookies.findElement(loginSignInButton).click();

            wait = new WebDriverWait(driverNoCookies, Duration.of(10, ChronoUnit.SECONDS));
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            driverNoCookies.findElement(logoutButton).click();

            driverNoCookies.quit();

        }catch (Exception e){
            e.printStackTrace();
            driverNoCookies.quit();
            Assert.fail();
        }


    }

}
