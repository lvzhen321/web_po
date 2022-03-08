package com.lemon.pages;

import com.lemon.common.Base_Page;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author lvzhen
 * @date 2022/2/27-16:29
 * @description:购物车页面
 */
public class Cart_Page extends Base_Page {
    //商品名称
    private By goodName = By.xpath("//div[@class='activity-goods']//a[@class='name']");
    //商品数量
    private  By goodNum = By.xpath("//div[@class ='activity-goods']/div[1]//input[@readonly='readonly']");
    //商品价格
    private By getPrice = By.xpath("//div[@class ='activity-goods']/div[1]//div[@class='unit-price']");
    //选中【全选】
    private  By allSele = By.xpath("//div[@class='check-all']//input[@type ='checkbox']");
    //定位删除选中商品
    private  By allDele = By.linkText("删除选中商品");
    //父类已经实例化webdriver，因此子类直接调用父类的有参构造，不需要单独实例化
    public Cart_Page(WebDriver driver){
        super(driver);
    }
    //获取商品名称
    public String nameGetText(){
        String name = getEelementText(3,goodName,"购物车-商品名称");
        return name;
    }
    //获取商品数量
    public String NumGetText(){
        String Num = getElementAttribute(3,goodNum,"value","购物车-商品数量");
        return Num;
    }
    public String priceGetText(){
        String price = getEelementText(3,getPrice,"购物车-商品价格");
        return price;
    }
}
