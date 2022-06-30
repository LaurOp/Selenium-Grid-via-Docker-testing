package LoginTestCases;

import BaseClasses.BaseForLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MultipleBrowsersTest extends BaseForLogin {

    private static class threadBodyMultipleBrowsers implements  Runnable { //thread body class

        private final WebDriver browser;

        public threadBodyMultipleBrowsers(WebDriver driv) {
            browser = driv;
        }

        @Override
        public void run() { //this is the method that will be executed in the thread

            browser.get(url);

            browser.findElement(loginButton).click();

            browser.findElement(loginEmail).sendKeys(loginmail);
            browser.findElement(loginPass).sendKeys(loginpassword);
            browser.findElement(loginSignInButton).click();

            WebDriverWait wait = new WebDriverWait(browser, Duration.of(5, ChronoUnit.SECONDS));
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));

            browser.findElement(logoutButton).click();
        }
    }

    @Test   (groups = "grid2", dependsOnGroups = "grid1")
    public void multipleBrowsers(){ // will use parallel testing; each browser has it's own thread
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("browserName", "firefox");

        WebDriver driver2 = new RemoteWebDriver(dc);    // we'll use firefox as our second browser

        try{
            var thr1 = new Thread(new threadBodyMultipleBrowsers(driver));
            var thr2 = new Thread(new threadBodyMultipleBrowsers(driver2));

            thr1.start();
            thr2.start();

            thr1.join();
            thr2.join();


        }
        catch (Exception e){
            driver2.quit();
            Assert.fail();
        }


        driver2.quit();
    }

}
