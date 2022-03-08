package com.lemon.pages;

import com.lemon.common.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author lvzhen
 * @date 2022/2/27-13:51
 * @description:登录页面元素及操作封装
 */
public class Login_Page extends Base_Page {
   /* 1.元素定位*/
    private By userName = By.xpath("//input[@placeholder='请输入手机号/用户名']");
    private By passWord = By.xpath("//input[@placeholder='请输入密码']");
    private By login = By.xpath("//a[@class='login-button']");
    private  By warn = By.xpath("//p[text()='账号或密码不正确']");

    /*有参构造*/
    public Login_Page(WebDriver driver){
        super(driver);
    }
    /*.元素操作*/
    public void Login(String name,String word){
//        WaitElementVisibility(driver,3,userName).sendKeys(name);
        putKeys(3,userName,name,"登录页-用户名");
//        WaitElementVisibility(driver,3,passWord).sendKeys(word);
        putKeys(3,passWord,word,"登录页-密码");
        click(3,login,"登录页-登录");
    }
    //获取登录提示文本信息
    public String getLoginText(){
        String text = getEelementText(2, warn, "登录页——提示信息");
        return text;
    }
}
