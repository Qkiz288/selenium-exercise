package com.kkukielka.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

@Log4j2
public class BasePageObject<T> {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    @SuppressWarnings("unchecked")
    protected T getPage(String url) {
        log.info(String.format("Opening Page: %s", url));
        driver.get(url);
        return (T) this;
    }

    protected void waitForVisibilityOf(By element, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                log.error("This message is only for testing purposes");
                log.debug("Attempt number: " + attempts);
                waitFor(ExpectedConditions.visibilityOfElementLocated(element),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
            } catch (StaleElementReferenceException e) {
                log.error("Element not visible!");
            }
            attempts++;
        }
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutInSeconds) {
        timeoutInSeconds = Objects.isNull(timeoutInSeconds) ? 30 : timeoutInSeconds;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(condition);
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
