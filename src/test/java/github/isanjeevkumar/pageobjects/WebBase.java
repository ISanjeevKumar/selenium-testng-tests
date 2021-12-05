package github.isanjeevkumar.pageobjects;

import org.openqa.selenium.WebDriver;

public class WebBase {
    
    protected WebDriver driver;
    protected int timeOutInSecs = 60; 
    
    public WebBase(WebDriver driver) {
        this.driver = driver;

    }

    protected boolean success(String message) {
        System.out.println(message);
        return true;
    }
}
