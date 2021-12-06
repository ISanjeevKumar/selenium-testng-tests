package github.isanjeevkumar.tests;

import org.testng.annotations.Test;

import github.isanjeevkumar.pageobjects.SauceDemoApp;
import github.isanjeevkumar.pageobjects.ProductsPage.Product;

public class AddToCartTests {
    
    @Test
    public void addProductsToCartPostLogin() {
        SauceDemoApp sauceDemoApp = null;
        try {
            sauceDemoApp = new SauceDemoApp();
            sauceDemoApp.navigateToApp();
            sauceDemoApp.homePage().login("problem_user", "secret_sauce");
            sauceDemoApp.productsPage().addToCart(Product.BACKPACK);
            sauceDemoApp.productsPage().addToCart(Product.BIKE_LIGHT);
            sauceDemoApp.productsPage().addToCart(Product.FLEECE_JACKET);
            sauceDemoApp.productsPage().removeFromCart(Product.BACKPACK);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            sauceDemoApp.dispose();
        }
    }
}
