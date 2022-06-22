package HomepageTestCases;

import BaseClasses.BaseForHomepage;
import TestSuites.Listener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DefaultLanguageEnglishTest extends BaseForHomepage {

    @Test
    public void defaultLanguageEnglishTest() {
        driver.get(url);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(languageDropDown));
            WebElement lang = driver.findElement(languageDropDown);

            Assert.assertTrue(lang.isDisplayed());
            Assert.assertTrue(lang.getText().contains("EN"));
            Assert.assertTrue(lang.findElement(By.cssSelector("img:first-child")).getAttribute("src").contains("united-kingdom"));

//            System.out.println("debug " + log.isDebugEnabled());
            Listener.log.info("Default language is English");
            Listener.log.warn("Default language is English");
            Listener.log.error("Default language is English");
        }

        catch (Exception ignored) {
            Assert.fail();
        }
    }

}
