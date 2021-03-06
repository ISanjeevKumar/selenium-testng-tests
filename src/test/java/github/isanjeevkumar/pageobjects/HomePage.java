package github.isanjeevkumar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import github.isanjeevkumar.enums.RelativeByLocator;
import github.isanjeevkumar.selenium.WebElementFinder;

public class HomePage extends WebBase {

    protected WebElement username() throws Exception{return WebElementFinder.getElement(driver,By.id("user-name"), timeOutInSecs);}
    protected WebElement password() throws Exception{return WebElementFinder.getElementByIdOrName(driver,"password", timeOutInSecs);}
    protected WebElement loginBtn() throws Exception{return WebElementFinder.getElementByRelativeLocator(driver,password(),By.tagName("input"),RelativeByLocator.BELOW, timeOutInSecs);}
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public boolean login(String username, String password) throws Exception{
        try {
             username().sendKeys(username);
             password().sendKeys(password);
             loginBtn().click();
            return success("Successfully processed login");
        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            throw ex;
        }
    }
}
