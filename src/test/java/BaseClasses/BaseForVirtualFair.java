package BaseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class BaseForVirtualFair {

    static public WebDriver driver;
    static public WebDriverWait wait;

    static protected String mainurl = "https://careersinwhite.com/";
    static protected String url = "https://careersinwhite.com/virtualfair";
    static protected By enterButton = By.xpath("//div[contains(@class, 'enterButton')][text()='Enter']");
    static protected By infoBoothEntrance = By.xpath("//div[@id='virtualFairBase']//a[@class='informationFloor']");
    static protected By jobsHallEntrance = By.xpath("//div[@id='virtualFairBase']//a[@class='jobsFloor']");
    static protected By conferenceHallEntrance = By.xpath("//div[@id='virtualFairBase']//a[@class='conferenceFloor']");
    static protected By chatInfoDesk = By.xpath("//div[@class='tab-row']/ul/li[3]/a");
    static protected By loginPopup = By.xpath("//div[contains(@class, 'modal-inner login-modal animated fadeIn')]");
    static protected By logoutButton = By.xpath("//a[text() = 'Logout']");
    static protected By playConference = By.xpath("//div[contains(@class,'play-video')]");
    static protected By backArrow = By.xpath("//div[contains(@class,'backButtonVirtualFair')]/span");
    static protected By jobCounter = By.xpath("//div[contains(@class, 'col-md-9')]//p/b");


    @BeforeSuite
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        //  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void repeatedSetup(){

        driver.get(mainurl);

        try{
            driver.findElement(logoutButton).click();
        }
        catch (Exception ignored){}

        driver.get(url);

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(enterButton));
            driver.findElement(enterButton).click();
        }
        catch (Exception ignored){
        }
    }


    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}
