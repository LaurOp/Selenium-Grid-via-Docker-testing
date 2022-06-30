package BaseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
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


    static protected String loginmail;
    static protected String loginmail2 = "lauroprea02@gmail.com";
    static protected String loginpassword;


    protected WebDriver driver;

    @Parameters({"loginmail", "loginpassword"})
    @BeforeMethod
    public void setup(@Optional("oprealaur@yahoo.com") String loginmail, @Optional("passQA123") String loginpassword) throws MalformedURLException {
        BaseForLogin.loginmail = loginmail;
        BaseForLogin.loginpassword = loginpassword;

        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();


        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("browserName", "chrome");

        driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);

//        dc. setCapability("headless", true);

//        var options = new ChromeOptions();
//        options.addArguments("--user-data-dir=C:\\Users\\lauro\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("network.cookie.cookieBehavior", 2);
//
//        options.setExperimentalOption("prefs", prefs);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @AfterMethod (alwaysRun = true)
    public void cleanup(){
        driver.quit();
    }


}
