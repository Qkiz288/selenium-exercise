package com.kkukielka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicTest {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver_99");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dice.com/");
        driver.quit();
    }

}
