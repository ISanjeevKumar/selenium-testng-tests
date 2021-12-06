package github.isanjeevkumar.pageobjects;

import org.openqa.selenium.WebDriver;

import github.isanjeevkumar.enums.BrowserType;
import github.isanjeevkumar.enums.ExecutionType;
import github.isanjeevkumar.selenium.BrowserManager;

public class SauceDemoApp {

    private HomePage homepage;
    private ProductsPage productsPage;

    private WebDriver driver;

    public SauceDemoApp() throws Exception {
        driver = BrowserManager.getWebDriver(ExecutionType.Local, BrowserType.CHROME);
    }

    public HomePage homePage() {
        if (homepage == null) {
            homepage = new HomePage(driver);
        }
        return homepage;
    }

    public ProductsPage productsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage(driver);
        }
        return productsPage;
    }

    public void navigateToApp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    public void dispose() {
        driver.quit();
        driver = null;
    }

}
