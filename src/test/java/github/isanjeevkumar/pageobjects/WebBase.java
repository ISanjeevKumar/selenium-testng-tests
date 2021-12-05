package github.isanjeevkumar.pageobjects;

import org.openqa.selenium.WebDriver;

public class WebBase {
    
    protected WebDriver driver;
    protected int timeOutInSecs = 60; 
    
    public WebBase(WebDriver driver) {
        this.driver = driver;

    }

    protected boolean success(){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElements[0]);
        return true;
    }
}
