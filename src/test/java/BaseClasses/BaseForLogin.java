package BaseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseForLogin {

    static protected String url = "https://careersinwhite.com/";

    static protected By loginButton = By.xpath("//div[@class='login_item']//a");
    static protected By loginEmail = By.xpath("//input[@type='text'][@placeholder='Email']");
    static protected By loginPass = By.xpath("//input[@type='password']");
    static protected By loginSignInButton = By.xpath("//div[contains(@class, 'submit')]");
    static protected By loginRemember = By.xpath("//*[contains(text(), 'remember me')]"); // not implemented
    static protected By loginForgot = By.xpath("//*[contains(text(), \"Don't remember \")]");
    static protected By loginCreate = By.xpath("//*[contains(text(), \"Don't have\")]");
    static protected By loginPopUp = By.xpath("//div[contains(@class,'login-modal')]");
    static protected By greetings = By.xpath("//div[@class='greetings']");
    static protected By logoutButton = By.xpath("//a[text() = 'Logout']");
    static protected By invalidLogin = By.xpath("//div[contains(@class,'login-modal')]//div[text() ='Invalid user or password.']");


    static protected String loginmail = "oprealaur@yahoo.com";
    static protected String loginmail2 = "lauroprea02@gmail.com";
    static protected String loginpassword = "passQA123";


    static public WebDriver driver;

    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();

        var options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\lauro\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("network.cookie.cookieBehavior", 2);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void cleanup(){
        driver.quit();
    }

}
