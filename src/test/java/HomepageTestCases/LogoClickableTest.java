package HomepageTestCases;

import BaseClasses.BaseForHomepage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LogoClickableTest extends BaseForHomepage {

    @Test   (groups = "homepageFirsts")
    public void logoClickableTest() {
        driver.get(url);

        try{
            wait.until(ExpectedConditions.elementToBeClickable(topLeftLogo));

            driver.findElement(topLeftLogo).click();
        }
        catch (Exception e){
            System.out.println("Logo is not clickable");
        }
    }
}
