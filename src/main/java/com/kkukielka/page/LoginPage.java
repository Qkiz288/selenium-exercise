package com.kkukielka.page;

import com.kkukielka.user.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject<LoginPage> {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    private final By username = By.cssSelector("#user-name");
    private final By password = By.cssSelector("#password");
    private final By loginButton = By.cssSelector("#login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        this.getPage(PAGE_URL);
    }

    public void login(User user) {
        this.enterCredentials(user);
        clickLoginButton();
    }


    public void enterCredentials(User user) {
        this.type(user.getLogin(), this.username);
        this.type(user.getPassword(), this.password);
    }

    public void clickLoginButton() {
        click(this.loginButton);
    }

}
