package com.lemon.testcase;
import com.lemon.common.Base_Test;
import com.lemon.pages.Cart_Page;
import com.lemon.pages.GoodsDetial_Page;
import com.lemon.pages.Index_Page;
import com.lemon.pages.Login_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author lvzhen
 * @date 2022/2/27-14:51
 * @description:加入购物车流程测试
 */
public class addCart_Test extends Base_Test {
    @Test
    public void addCart(){
        WebDriver driver = opeBrowser("chrome");
        toUrl("http://mall.lemonban.com:3344");
        driver.manage().window().maximize();//页面最大话
        //登录
        Index_Page index_page = new Index_Page(driver);
        index_page.login_Click();
        Login_Page login_page = new Login_Page(driver);//登录页面对象实例化
        login_page.Login("waiwai","lemon123456");//用户自定义输入信息登录
        //浏览商品
        index_page.goodsList();//切换到商品列表栏
        index_page.goodSelect();//选择商品
        //商品详情页面，获取商品数据
        GoodsDetial_Page goodsDetial_page = new GoodsDetial_Page(driver);
        //商品名称
        String goodname = goodsDetial_page.nameGetText();
        //获取商品价格
        String goodprice = goodsDetial_page.priceGetTex();
        //获取商品数量
        String goodnum = goodsDetial_page.numGetTex();
        //添加购物车
        goodsDetial_page.addcart();
        //进入购物车
        index_page.cart();
        //获取购物车页面的商品信息
        Cart_Page cart_page = new Cart_Page(driver);
        //获取商品名称
        String goodName_true = cart_page.nameGetText();
        //商品名称断言
        myAssertEqual(goodName_true,goodname);
        //获取商品数量
        String num_ture = cart_page.NumGetText();
        myAssertEqual(num_ture,goodnum);//商品数量断言
        //获取商品价格
        String price_ture = cart_page.priceGetText();
        myAssertEqual(price_ture,goodprice);//商品价格断言


    }
}
