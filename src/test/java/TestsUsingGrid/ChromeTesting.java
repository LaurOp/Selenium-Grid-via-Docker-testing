package TestsUsingGrid;

import BaseClasses.BaseForGrid;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ChromeTesting extends BaseForGrid {

    @Test (invocationCount = 8, threadPoolSize = 8)
    public void testChrome() throws MalformedURLException {
        WebDriver localdriver = initialize("chrome");
        localdriver.get("https://www.google.com");



        localdriver.quit();
    }


}
