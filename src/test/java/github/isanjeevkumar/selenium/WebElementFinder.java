package github.isanjeevkumar.selenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import com.google.common.base.Function;

import org.apache.commons.lang.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.WebDriverWait;

import github.isanjeevkumar.enums.RelativeByLocator;

public class WebElementFinder {

    public static WebElement getElement(WebDriver driver, final By elementLocator, int timeOutInSecs)
            throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecs));
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(ElementNotVisibleException.class);
            return wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return getElement(driver, elementLocator);
                }
            });

        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            throw ex;
        }

    }

    public static WebElement getElementByIdOrName(WebDriver driver, final String byIdOrName, int timeOutInSecs)
            throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecs));
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(ElementNotVisibleException.class);
            return wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return getByIdOrName(driver, byIdOrName);
                }
            });

        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            throw ex;
        }

    }

    public static WebElement getElementByChained(WebDriver driver, final ByChained chainedValue, int timeOutInSecs)
            throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecs));
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(ElementNotVisibleException.class);
            return wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return getByChained(driver, chainedValue);
                }
            });

        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            throw ex;
        }

    }

    public static WebElement getElementByRelativeLocator(WebDriver driver, WebElement referenceElement,
            final By elementLocator, RelativeByLocator relativeBy,
            int timeOutInSecs)
            throws Exception {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSecs));
            wait.ignoring(NoSuchElementException.class);
            wait.ignoring(ElementNotVisibleException.class);
            return wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return getRelativeElement(driver, referenceElement, elementLocator, relativeBy);
                }
            });

        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            throw ex;
        }

    }

    private static WebElement getElement(final SearchContext searchContext, final By elementLocator) {
        WebElement element = searchContext.findElement(elementLocator);
        if (element.isDisplayed() && element.isEnabled()) {
            return element;
        }
        throw new ElementNotVisibleException("WebElement with locator " + elementLocator + " is not visible.");
    }

    private static WebElement getByIdOrName(final SearchContext searchContext, final String elementLocatorValue) {
        WebElement element = searchContext.findElement(new ByIdOrName(elementLocatorValue));
        if (element.isDisplayed() && element.isEnabled()) {
            return element;
        }
        throw new ElementNotVisibleException("WebElement with locator " + elementLocatorValue + " is not visible.");
    }

    private static WebElement getByChained(final SearchContext searchContext, final ByChained getByChained) {
        WebElement element = searchContext.findElement(getByChained);
        if (element.isDisplayed() && element.isEnabled()) {
            return element;
        }
        throw new ElementNotVisibleException("WebElement with locator " + getByChained.toString() + " is not visible.");
    }

    private static WebElement getRelativeElement(final SearchContext searchContext, WebElement referenceElement,
            final By elementLocator, RelativeByLocator relativeLocator) {
        RelativeBy relativeBy = RelativeLocator.with(elementLocator);
        WebElement element = null;
        switch (relativeLocator) {
            case ABOVE:
                element = searchContext.findElement(relativeBy.above(referenceElement));
                break;
            case BELOW:
                element = searchContext.findElement(relativeBy.below(referenceElement));
                break;
            case LEFT_OF:
                element = searchContext.findElement(relativeBy.toLeftOf(referenceElement));
                break;
            case NEAR:
                element = searchContext.findElement(relativeBy.near(referenceElement));
                break;
            case RIGHT_OF:
                element = searchContext.findElement(relativeBy.toRightOf(referenceElement));
                break;
            default:
                throw new NotImplementedException("relativeLocatorBy is not implemented. Please check.");

        }

        if (element.isDisplayed() && element.isEnabled()) {
            return element;
        }
        throw new ElementNotVisibleException(
                "WebElement with locator " + elementLocator.toString() + " is not visible.");
    }
}
