package com.kkukielka.page;

import com.kkukielka.component.Button;
import com.kkukielka.component.Component;
import com.kkukielka.component.TextField;
import com.kkukielka.model.UserCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePageObject<LoginPage> {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    private final TextField username = new TextField(driver, By.cssSelector("#user-name"));
    private final TextField password = new TextField(driver, By.cssSelector("#password"));
    private final Button loginButton = new Button(driver, By.cssSelector("#login-button"));
    private final Component loginErrorMessage = new Component(driver, By.cssSelector("div.error-message-container"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        this.getPage(PAGE_URL);
    }

    public InventoryPage login(UserCredentials userCredentials) {
        this.enterCredentials(userCredentials);
        clickLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.waitForPageToLoad();
        return inventoryPage;
    }

    public void enterCredentials(UserCredentials userCredentials) {
        this.username.type(userCredentials.getLogin());
        this.password.type(userCredentials.getPassword());
    }

    public InventoryPage clickLoginButton() {
        this.loginButton.click();
        return new InventoryPage(driver);
    }

    public void verifyLoginErrorMessageDisplayed() {
        Assert.assertTrue(loginErrorMessage.isDisplayed());
    }

}
