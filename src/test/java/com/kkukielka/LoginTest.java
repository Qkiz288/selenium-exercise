package com.kkukielka;

import com.kkukielka.page.InventoryPage;
import com.kkukielka.page.LoginPage;
import com.kkukielka.user.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final User STANDARD_USER = User.STANDARD_USER;
    private static final String EXPECTED_PAGE_TITLE = "Swag Labs";

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        InventoryPage inventoryPage = loginPage.login(STANDARD_USER);

        String actualTitle = inventoryPage.getTitle();
        Assert.assertEquals(actualTitle, EXPECTED_PAGE_TITLE, "Page title should be equal to expected");
    }

}
