package TestSuites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.ArrayList;

public class  Listener implements ITestListener {

        public static Logger log = LogManager.getLogger();

        static ArrayList<String> finalSummary = new ArrayList<>();

        @Override
        public void onFinish(ITestContext context) {
            finalSummary.forEach(System.out::println);
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            finalSummary.add("Test passed: " + result.getName());
        }

        @Override
        public void onTestFailure(ITestResult result) {
            finalSummary.add("TEST *FAILED*: " + result.getName());
            log.error("Test " +  result.getName() + " has failed");
        }

        @Override
        public void onTestSkipped(ITestResult result) {

            finalSummary.add("Test skipped: " + result.getName());

            log.warn("Test " +  result.getName() + " skipped");
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            finalSummary.add("Test failed but within success percentage: " + result.getName());
        }

}
