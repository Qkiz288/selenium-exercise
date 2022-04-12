package com.kkukielka.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject<T> {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    @SuppressWarnings("unchecked")
    protected T getPage(String url) {
        driver.get(url);
        return (T) this;
    }

    protected void type(String text, By element) {
        find(element).sendKeys(text);
    }

    private WebElement find(By element) {
        return driver.findElement(element);
    }

    protected void click(By element) {
        find(element).click();
    }
}
