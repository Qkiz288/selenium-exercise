package com.kkukielka;

import org.testng.annotations.Test;

public class AnotherTest extends BaseTest {

    @Test
    public void test() {
        driver.get("https://www.linkedin.pl");
    }

}
