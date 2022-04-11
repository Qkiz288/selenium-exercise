package com.kkukielka;

import org.testng.annotations.Test;

public class BasicTest extends BaseTest {

    @Test
    public void test() {
        driver.get("https://www.dice.com/");
    }

}
