package BaseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseForGrid {
    protected WebDriver driver;

    protected WebDriver initialize(@NotNull String browserName) throws MalformedURLException {

        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();

        DesiredCapabilities dc = new DesiredCapabilities();

        switch (browserName) {
            case "chrome" -> dc.setCapability("browserName", "chrome");
            case "firefox" -> dc.setCapability("browserName", "firefox");
            case "ie" -> dc.setCapability("browserName", "internet explorer");
            case "edge" -> dc.setCapability("browserName", "MicrosoftEdge");
            case "safari" -> dc.setCapability("browserName", "safari");
            default -> System.out.println("Browser name is not correct");
        }


        driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);

        return driver;

    }

//    @AfterMethod
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
