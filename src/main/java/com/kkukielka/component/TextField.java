package com.kkukielka.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextField extends Component {
    public TextField(WebDriver driver, By element) {
        super(driver, element);
    }

    public void type(String text) {
        find(element).sendKeys(text);
    }
}
