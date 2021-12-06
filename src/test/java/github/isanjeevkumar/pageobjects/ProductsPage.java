package github.isanjeevkumar.pageobjects;

import org.apache.commons.lang.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import github.isanjeevkumar.selenium.WaitPage;
import github.isanjeevkumar.selenium.WebElementFinder;

public class ProductsPage extends WebBase {

    private String actionToAdd = "add-to-cart";
    private String actionToRemove = "remove";

    public enum Product {
        BACKPACK, BIKE_LIGHT, FLEECE_JACKET
    }

    protected WebElement addToCartSauceLabsBackpack(String addOrRemove) throws Exception {
        return WebElementFinder.getElement(driver, By.id(addOrRemove.toLowerCase() + "-sauce-labs-backpack"),
                timeOutInSecs);
    }

    protected WebElement addToCartBikeLight(String addOrRemove) throws Exception {
        return WebElementFinder.getElement(driver, By.id(addOrRemove.toLowerCase() + "-sauce-labs-bike-light"),
                timeOutInSecs);
    }

    protected WebElement addToFleeceJacket(String addOrRemove) throws Exception {
        return WebElementFinder.getElement(driver, By.id(addOrRemove.toLowerCase() + "-sauce-labs-fleece-jacket"),
                timeOutInSecs);
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean addToCart(Product product) throws Exception {
        try {
            WaitPage.waitForPageLoad(driver);
            addOrRemoveProduct(product, actionToAdd);
            return success("Successfully added "+product.toString()+" to cart");
        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            throw ex;
        }
    }

    public boolean removeFromCart(Product product) throws Exception {
        try {
            addOrRemoveProduct(product, actionToRemove);
            return success("Successfully removed "+product.toString()+" from cart");
        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());
            throw ex;
        }
    }

    private void addOrRemoveProduct(Product product, String action) throws Exception {
        switch (product) {
            case BACKPACK:
                addToCartSauceLabsBackpack(action).click();
                break;
            case BIKE_LIGHT:
                addToCartBikeLight(action).click();
                break;
            case FLEECE_JACKET:
                addToFleeceJacket(action).click();
                break;
            default:
                throw new NotImplementedException(product + " is not implemented yet.Please check");

        }
    }

}
