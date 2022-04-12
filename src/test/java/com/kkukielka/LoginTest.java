package com.kkukielka;

import com.kkukielka.page.LoginPage;
import com.kkukielka.user.User;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final User STANDARD_USER = User.STANDARD_USER;

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(STANDARD_USER);
    }

}
