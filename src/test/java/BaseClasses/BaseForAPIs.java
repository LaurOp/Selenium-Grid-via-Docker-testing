package BaseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class BaseForAPIs {  // UNUSED

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeSuite
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, Duration.of(4, ChronoUnit.SECONDS));
    }


    @AfterSuite
    public void cleanup(){
        driver.quit();
    }

}
