package com.lemon.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.xml.dom.OnElementList;

import java.sql.Driver;

/**
 * @author lvzhen
 * @date 2022/2/27-14:41
 * @description:页面操作的封装
 */
public class Base_Page {
    private WebDriver driver;
    public Base_Page(WebDriver driver){
        this.driver = driver;
    }
    //引入日志打印方法
    private Logger logger = Logger.getLogger(Base_Page.class);
    //隐士等待元素
    public WebElement WaitElementPresence(long time, By by){ //元素在源代码中存在等待封装
        WebElement webElement = null;
        try{
            WebDriverWait wait = new WebDriverWait(driver,time);
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            logger.info("等待元素存在定位元素失败");
        }
        return webElement;
    }
    public WebElement WaitElementVisibility(long time, By by){//元素在源代码中可见等待封装
        WebElement webElement = null;
        try{
            WebDriverWait wait = new WebDriverWait(driver,time);
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            logger.info("等待元素可见定位元素失败");
        }
         return webElement;
    }
    public WebElement WaitElementBeClickable(long time, By by){
        WebElement webElement = null;
        try{
            WebDriverWait wait = new WebDriverWait(driver,time);
            webElement = wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            logger.info("等待元素可被点击定位元素失败");
        }
        return webElement;
    }
    //元素点击操作,参数列表 驱动、等待时间、元素定位、元素描述
    public void click(long l,By by,String desc){
        WaitElementBeClickable(l,by).click();
        logger.info("点击"+"["+desc+"]");
    }
    //元素中输入值操作,参数列表 驱动、等待时间、元素定位、输入值，描述
    public void putKeys(long l,By by,String data,String desc){
        WaitElementVisibility(l,by).sendKeys(data);
        logger.info("向"+"["+desc+"]"+"输入"+"["+data+"]");
    }
    //获取元素文本属性getText()
    public String getEelementText(long l,By by,String desc){
        String text = WaitElementVisibility(l, by).getText();
        logger.info("获取"+"["+desc+"]"+"的文本值为"+"["+text+"]");
        return text;
    }
    //获取元素的属性值
    public String getElementAttribute(long l,By by,String str,String desc){
        String text = WaitElementVisibility(l, by).getAttribute(str);
        logger.info("获取"+"["+desc+"]"+"的"+"["+str+"]"+"属性值为"+"["+text+"]");
        return text;
    }
}
