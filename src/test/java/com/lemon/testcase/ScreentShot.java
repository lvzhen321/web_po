package com.lemon.testcase;
import com.lemon.common.Base_Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

/**
 * @author lvzhen
 * @date 2022/3/5-18:45
 * @description:本地截图
 */
public class ScreentShot extends Base_Test {
    @Test
    public void getScreentShot() throws IOException {
        WebDriver driver = opeBrowser("chrome");
        driver.get("https://www.fxiaoke.com/pc-login/build/login.html#chats");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File scrfile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destfile = new File("E:\\1.png");
        FileUtils.copyFile(scrfile, destfile);
    }
}
