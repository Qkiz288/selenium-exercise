package com.kkukielka.component;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RequiredArgsConstructor
public class Component {

    protected final WebDriver driver;
    protected final By element;

    public String getText() {
        return find(element).getText();
    }

    public void click() {
        find(element).click();
    }

    public boolean isDisplayed() {
        return find(element).isDisplayed();
    }

    protected WebElement find(By element) {
        return driver.findElement(element);
    }
}
