package github.isanjeevkumar.tests;

import org.testng.annotations.Test;

import github.isanjeevkumar.pageobjects.SauceDemoApp;

public class LoginTests extends TestBase {

    @Test
    public void loginWithValidUserCredentials() {
        SauceDemoApp sauceDemoApp = null;
        try {
            sauceDemoApp = new SauceDemoApp();
            sauceDemoApp.navigateToApp();
            sauceDemoApp.homePage().login("problem_user", "secret_sauce");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            sauceDemoApp.dispose();
        }
    }

}
