package com.kkukielka;

import com.kkukielka.dataprovider.CsvDataProvider;
import com.kkukielka.model.UserCredentials;
import com.kkukielka.page.InventoryPage;
import com.kkukielka.page.LoginPage;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void loginTest(Map<String, String> testData) {
        String testNumber = testData.get("no");
        String username = testData.get("username");
        String password = testData.get("password");
        String description = testData.get("description");
        boolean expected = Boolean.parseBoolean(testData.get("expected"));
        UserCredentials userCredentials = new UserCredentials(username, password);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterCredentials(userCredentials);
        InventoryPage inventoryPage = loginPage.clickLoginButton();

        if (expected) {
            inventoryPage.isPageDisplayed();
        } else {
            loginPage.verifyLoginErrorMessageDisplayed();
        }
    }

}
