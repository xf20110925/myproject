package com.xf.test.selinum;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by xuefeng on 2017/8/6.
 */
public class TmallShopSearchTest {
    private WebDriverPool pool;

    @Before
    public void init() {
        pool = new WebDriverPool(5);
    }

    @Test
    public void shopSearchTest() throws InterruptedException {
        final WebDriver webDriver = pool.get();
        webDriver.get("https://www.tmall.com/");
        final WebElement element = webDriver.findElement(By.name("q"));
        element.sendKeys("李宁官方网店");
        element.submit();
        String pageSource = webDriver.getPageSource();
        System.out.println(pageSource);
        final String currentUrl = webDriver.getCurrentUrl();
        System.out.println(currentUrl);
      /*
        final WebElement nextPage = webDriver.findElement(By.cssSelector("/b[class@ui-page-next]"));
        nextPage.click();
        webDriver.navigate().forward();
        pageSource = webDriver.getPageSource();
        System.out.println(pageSource);*/
    }
}
