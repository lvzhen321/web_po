package com.lemon.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author lvzhen
 * @date 2022/2/27-13:41
 * @description:公共测试类
 */
public class Base_Test {
    private Logger logger = Logger.getLogger(Base_Test.class);
    public WebDriver driver;
    public  WebDriver opeBrowser (String browser){
        //父类接受子类，返回值类型
        if("chrome".equalsIgnoreCase(browser)){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            logger.info("*****打开chrome浏览器*****");
            return driver;
        }else if ("fireFox".equalsIgnoreCase(browser)){
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            logger.info("*****打开firefox浏览器*****");
            return driver;
        }
        return null;
    }
    //访问指定的网址
    public void toUrl(String url){
        driver.get(url);
        logger.info("访问"+url+"页面");
    }
    //断言日志(重载)
    public void myAssertEqual(String real,String except ){
        Assert.assertEquals(real,except);
        logger.info("断言日志"+"真实值"+"["+real+"]"+","+"期望值"+"["+except+"]");
    }
    public void myAssertEqual(int real,int except ){
        Assert.assertEquals(real,except);
        logger.info("断言日志"+"真实值"+"["+real+"]"+","+"期望值"+"["+except+"]");
    }
    public  void myAssertTrue(boolean condition){
        Assert.assertTrue(condition);
        logger.info("断言的真实值是"+condition);
    }




}
