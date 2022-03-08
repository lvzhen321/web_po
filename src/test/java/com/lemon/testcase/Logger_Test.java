package com.lemon.testcase;

import com.lemon.common.Base_Test;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author lvzhen
 * @date 2022/3/5-11:16
 * @description:rizhi
 */
public class Logger_Test extends Base_Test {
    private Logger logger = Logger.getLogger(Login_Test.class);
   @Test
   @Parameters({"browserName"})
   public void log(String browserName) {
        logger.info("info消息");
       WebDriver chrome = opeBrowser(browserName);
       chrome.get("https://blog.csdn.net/nbxinjian/article/details/52670540");
    }
}
