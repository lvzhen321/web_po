package com.lemon.pages;

import com.lemon.common.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author lvzhen
 * @date 2022/2/27-14:29
 * @description:首页
 */
public class Index_Page extends Base_Page {
    //登录元素定位
    private By login = By.linkText("登录");
    //首页商品元素定位
    private By goodsList = By.linkText("商品列表");
    private By goodSelect = By.xpath("//div[@class = 'list-con normalList']/div[2]//div[text()='商品名称']");
    private By cart = By.xpath("//span[@data-route='cart']");
    private  By welcome = By.xpath("//span[text()='欢迎来到柠檬班']");
    private WebDriver driver;
    //有参构造
    public Index_Page(WebDriver driver){
        super(driver);
    }
    //元素操作
    public void login_Click(){
        click(2,login,"首页-登录按钮");
    }
    public void goodsList(){
        try{Thread.sleep(2000);}
        catch(Exception e){
            System.out.println("商品列表加载时间需要更多");
        }
        click(2,goodsList,"首页-商品列表按钮");
    }
    public void goodSelect(){
        WaitElementPresence(3,goodSelect).click();
        click(3,goodSelect,"首页-选择商品");
    }
    public void cart(){
        WaitElementBeClickable(3,cart).click();
        click(3,cart,"首页-购物车");
    }
    //定位//span[text()='欢迎来到柠檬班']
    public String welcome(){
        String text = getEelementText(3, welcome, "首页-欢迎来到柠檬班");
        return text;
    }

}
