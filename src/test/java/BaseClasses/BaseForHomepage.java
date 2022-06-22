package BaseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class BaseForHomepage {
    public static WebDriver driver;
    public static WebDriverWait wait;
    //public static Logger log = LogManager.getLogger();

    static protected String url = "https://careersinwhite.com/";
    static protected By topLeftLogo = By.xpath("//img[@class='logo hidden-xs']");
    static protected By languageDropDown = By.xpath("//div[contains(@class, 'dropdown-option variant text-center')]");
    static protected By languageDropdownOptions = By.xpath("//div[@class='language-selector']//span[contains(@class, 'select2-selection select2-selection--single')]");

    @BeforeSuite
    public void setup(){
        // Configurator.setRootLevel(Level.DEBUG);
         Configurator.setRootLevel(Level.INFO);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, Duration.of(4, ChronoUnit.SECONDS));
    }


    @AfterSuite
    public void cleanup(){
        driver.quit();
    }

}
