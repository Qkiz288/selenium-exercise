package com.kkukielka.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObject<T> {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }
}
