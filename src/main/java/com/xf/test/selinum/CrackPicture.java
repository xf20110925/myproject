package com.xf.test.selinum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xuefeng on 2017-9-21.
 * 滑动验证码破解
 */
public class CrackPicture {

    static final WebDriverPool webDriverPool = new WebDriverPool();
    final WebDriver driver = webDriverPool.get();

    public CrackPicture() throws InterruptedException {
    }

    //打开目标网站并输入
    void inputParams(String kw) throws InterruptedException {
        String url = "http://www.gsxt.gov.cn/index";
        driver.get(url);
        driver.wait(2000);
        final WebElement element = driver.findElement(By.id("keyword"));
        element.sendKeys(kw);
        TimeUnit.SECONDS.sleep(1);
        WebElement clickEle = driver.findElement(By.id("btn_query"));
        clickEle.click();
        TimeUnit.SECONDS.sleep(1);
    }

    public String dragPic(String className, String regex) {
        final WebElement element = driver.findElement(By.cssSelector(className));
        final Pattern pattern = Pattern.compile(regex);
        final String style = element.getAttribute("style");
        final Matcher matcher = pattern.matcher(style);
        if (matcher.find())
            return matcher.group(1).replace("webp", "jpg");
        throw new RuntimeException("can not find element");
    }

    //下载图片
    public void getPicture(String imgUrl) {
        String Host = "static.geetest.com";
        String User_Agent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";

        img1 = StringIO.StringIO(self.repeat(img_url1, hd).content)
        img2 = StringIO.StringIO(self.repeat(img_url2, hd).content)
        return img1,img2
    }


    //获取图片
    public void hackGeetest(String kw) throws InterruptedException {
        boolean flag = true;
        inputParams(kw);
        while (flag) {
            String imgUrl1 = dragPic("gt_cut_fullbg_slice", "url\\(\"(.*?)\"\\)");
            String imgUrl2 = dragPic("gt_cut_fullbg_slice", "url\\((.*?)\\)");
        }

    }

}
