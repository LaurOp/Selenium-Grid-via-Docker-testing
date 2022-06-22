package HomepageTestCases;

import BaseClasses.BaseForHomepage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageDropDownDisplayedTest extends BaseForHomepage {

    @Test
    public void languageDropDownDisplayedTest() {
        driver.get(url);

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(languageDropDown));
            driver.findElement(languageDropDown).click();

            WebElement lang = driver.findElement(languageDropdownOptions);
            Assert.assertTrue(lang.isDisplayed());
            Assert.assertEquals(lang.getAttribute("aria-expanded"), "true");

        }
        catch (Exception ignored){
            Assert.fail();
        }
    }

}
