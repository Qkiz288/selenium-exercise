package com.kkukielka.testlistener;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

@Log4j2
public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
        log.info(tr.getTestContext().getCurrentXmlTest().getName() + " Test Success!");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        log.info(tr.getTestContext().getCurrentXmlTest().getName() + " Test Failure!");
    }

    @Override
    public void onStart(ITestContext testContext) {
        log.info(testContext.getCurrentXmlTest().getName() + " Test Start...");
    }

    @Override
    public void onFinish(ITestContext testContext) {
        log.info(testContext.getCurrentXmlTest().getName() + " Test Finish...");
    }
}
