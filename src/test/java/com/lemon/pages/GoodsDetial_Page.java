package com.lemon.pages;

import com.lemon.common.Base_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author lvzhen
 * @date 2022/2/27-15:16
 * @description:商品详情
 */
public class GoodsDetial_Page extends Base_Page {
    //获取商品信息
    private By goodName = By.xpath("//div[@class='name-box']//div[@class='name']");
    //获取商品库存
    private By goodNum = By.xpath("//input[@type='number']");
    //获取价格
    private By goodPrice = By.xpath("//div[@class='price-box']//div[@class='price']");
    //加入购物车元素
    private  By addCart = By.linkText("加入购物车");

    public GoodsDetial_Page(WebDriver driver){
        super(driver);
    }
    //加入购物车操作
    public void addcart(){
        click(3,addCart,"商品详情页面-加入购物车");
    }
    //获取商品名
    public String nameGetText(){
        String goodname = getEelementText(3, goodName,"商品详情页面-点击加入购物车商品名称");
        return goodname;
    }
    //获取商品数量
    public String numGetTex(){
        String goodnum = getElementAttribute(3,goodNum,"value","商品详情页面-点击加入购物车商品数量");
        return goodnum;
    }
    //获取商品价格
    public String priceGetTex(){
        String str = getEelementText(3,goodPrice,"商品详情页面-点击加入购物车商品价格");
        String [] str1 =str.split("\n");
        String price = str1[0]+str1[1]+str1[2];
        return price;
    }
}
