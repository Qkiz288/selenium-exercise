package com.kkukielka.test;

import com.kkukielka.BaseTest;
import com.kkukielka.dataprovider.CsvDataProvider;
import com.kkukielka.model.UserCredentials;
import com.kkukielka.page.InventoryPage;
import com.kkukielka.page.LoginPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import java.util.Map;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
    public void loginTest(Map<String, String> testData) {
        String testNumber = testData.get("no");
        String username = testData.get("username");
        String password = testData.get("password");
        String description = testData.get("description");
        boolean expected = Boolean.parseBoolean(testData.get("expected"));
        UserCredentials userCredentials = new UserCredentials(username, password);

        log.info(String.format("Executing test with data:\nNo.: %s\nUsername: %s\nPassword: %s\nDescription: "
                + "%s\nExpected to be logged in?: %s", testNumber, username, password, description, expected));

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
