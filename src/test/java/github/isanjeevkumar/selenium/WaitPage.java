package github.isanjeevkumar.selenium;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class WaitPage {
    
    public static void waitForPageLoad(WebDriver driver){
        try {
            (new WebDriverWait(driver, Duration.ofSeconds(30)))
            .until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    boolean isJavascriptExecuted = ((JavascriptExecutor)d).executeScript("return document.readyState").equals("complete");
                    boolean isAppInteractive =((JavascriptExecutor) d).executeScript("return document.readyState").toString().matches("interactive|complete");
                    return isJavascriptExecuted&&isAppInteractive;
                }
            });
        } catch (TimeoutException ex) {
             ((JavascriptExecutor)driver).executeScript("window.stop();");
        }
    }
}
