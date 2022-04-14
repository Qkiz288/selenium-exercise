package com.kkukielka;

import com.kkukielka.model.UserCredentials;
import com.kkukielka.page.InventoryPage;
import com.kkukielka.page.LoginPage;
import com.kkukielka.user.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final UserCredentials STANDARD_USER = User.STANDARD_USER.toUserCredentials();
    private static final UserCredentials INCORRECT_USER =
            new UserCredentials("incorrect_login", "incorrect_password");
    private static final String EXPECTED_PAGE_TITLE = "Swag Labs";

    @Test
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login(STANDARD_USER);

        String actualTitle = inventoryPage.getTitle();
        Assert.assertEquals(actualTitle, EXPECTED_PAGE_TITLE, "Page title should be equal to expected");
    }

    @Test
    public void negativeLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterCredentials(INCORRECT_USER);
        loginPage.clickLoginButton();
        loginPage.verifyLoginErrorMessageDisplayed();
    }

}
