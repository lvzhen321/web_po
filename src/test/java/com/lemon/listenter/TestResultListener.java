package com.lemon.listenter;

import com.lemon.common.Base_Test;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import java.io.File;

/**
 * @author lvzhen
 * @date 2022/3/5-19:53
 * @description:监听用例执行结果
 */
public class TestResultListener implements IHookable {
    @Override
    public void run(IHookCallBack CallBack, ITestResult TestResult) {
        CallBack.runTestMethod(TestResult);
        if (TestResult.getThrowable() != null){
          Base_Test base_test =  (Base_Test)TestResult.getInstance();
          TakesScreenshot takesScreenshot = (TakesScreenshot) base_test.driver;
          byte[] screenShot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
          add_to_allure(screenShot);
        }
    }
    @Attachment
    public byte[] add_to_allure(byte[] datas) {
        return datas;
    }
}
