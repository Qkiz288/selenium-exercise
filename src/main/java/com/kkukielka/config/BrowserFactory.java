package com.kkukielka.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver_100");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver_0.31.0");
                return new FirefoxDriver();
            default:
                throw new UnknownBrowserException(browser);
        }
    }

}
