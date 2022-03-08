package com.lemon.testcase;
import com.lemon.common.Base_Test;
import com.lemon.pages.Index_Page;
import com.lemon.pages.Login_Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author lvzhen
 * @date 2022/2/27-13:05
 * @description:登录测试用例
 */
public class Login_Test extends Base_Test {

    @Test
    @Parameters({"browserName"})
    public void Login_secuss(String browserName) {
        WebDriver driver = opeBrowser(browserName);
        toUrl("http://mall.lemonban.com:3344/");
        driver.manage().window().maximize();
        Index_Page index_page = new Index_Page(driver);
        index_page.login_Click();
        Login_Page login_page = new Login_Page(driver);//登录页面对象实例化
        login_page.Login("waiwai", "lemon123456");//用户自定义输入信息登录
        myAssertEqual(index_page.welcome(),"欢迎来到柠檬班");
    }
   /* @Test(dataProvider = "datas")
    public void login_failure(String phone,String pwd){
        WebDriver driver = opeBrowser("firefox");
        toUrl("http://mall.lemonban.com:3344/");
        driver.manage().window().maximize();
        Index_Page index_page = new Index_Page(driver);
        index_page.login_Click();
        Login_Page login_page = new Login_Page(driver);
        login_page.Login(phone,pwd);
        myAssertEqual(login_page.getLoginText(),"账号或密码不正确");
    }
    @DataProvider
    public Object[] datas(){
        Object[][] objects = {{"151278839931","123456"},
                {"1527283838","12233"},
                {"11111111111","1111111112"}
        };
        return objects;
    }*/


}
