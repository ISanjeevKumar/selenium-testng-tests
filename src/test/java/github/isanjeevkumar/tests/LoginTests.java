package github.isanjeevkumar.tests;

import org.testng.annotations.Test;

import github.isanjeevkumar.pageobjects.SauceDemoApp;

public class LoginTests extends TestBase {

    @Test
    public void loginWithValidUserCredentials() {
        try {
            SauceDemoApp sauceDemoApp = new SauceDemoApp();
            sauceDemoApp.navigateToApp();
            sauceDemoApp.homePage().login("username", "password");
            sauceDemoApp.dispose();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {

        }
    }

}
