package com.kkukielka.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePageObject<InventoryPage> {

    private final By menuButton = By.cssSelector("#react-burger-menu-btn");
    private final By shoppingCart = By.cssSelector("#shopping_cart_container");

    protected InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad() {
        waitForVisibilityOf(menuButton);
        waitForVisibilityOf(shoppingCart, 15);
    }
}
