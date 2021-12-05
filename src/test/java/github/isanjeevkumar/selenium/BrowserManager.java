package github.isanjeevkumar.selenium;

import org.apache.hc.core5.http.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import github.isanjeevkumar.enums.BrowserType;
import github.isanjeevkumar.enums.ExecutionType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {

    public static WebDriver getWebDriver(ExecutionType executionType, BrowserType browserType) throws Exception {
        switch (executionType) {
            case Local:
                return createLocalWebDriverDriver(browserType);
            case REMOTE_WEBDRIVER:
                return createRemoteWebDriver();
            default:
                throw new NotImplementedException();
        }
    }

    private static WebDriver createLocalWebDriverDriver(BrowserType browserType) throws Exception {
        try {
            switch (browserType) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("headless");
                    options.addArguments("window-size=1200x600");
                    return new ChromeDriver(options);
                case EDGE:
                    return null;
                case FIREFOX:
                    return null;
                default:
                    throw new NotImplementedException();

            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }

    private static WebDriver createRemoteWebDriver() {
        try {
            return null;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw ex;
        }
    }
}
