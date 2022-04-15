package com.kkukielka.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InventoryPage extends BasePageObject<InventoryPage> {

    private static final String EXPECTED_PAGE_TITLE = "Swag Labs";

    private final By menuButton = By.cssSelector("#react-burger-menu-btn");
    private final By shoppingCart = By.cssSelector("#shopping_cart_container");

    protected InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad() {
        waitForVisibilityOf(menuButton);
        waitForVisibilityOf(shoppingCart, 15);
    }

    public void isPageDisplayed() {
        String actualTitle = this.getTitle();
        Assert.assertEquals(actualTitle, EXPECTED_PAGE_TITLE, "Page title should be equal to expected");
    }
}
