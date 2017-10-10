package com.xf.test.selinum;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by xuefeng on 2017/8/6.
 */
public class TianyanchaSearchTest {
    private WebDriverPool pool;

    @Before
    public void init() {
        pool = new WebDriverPool(5);
    }

    @Test
    public void searchTest() throws InterruptedException {
        final WebDriver webDriver = pool.get();
        String url = String.format("https://www.tianyancha.com/search?key=%s&checkFrom=searchBox", "富力地产");
        webDriver.get(url);
        final WebElement element = webDriver.findElement(By.id("home-main-search"));
        element.sendKeys("富力地产");
        element.submit();
        String pageSource = webDriver.getPageSource();
        System.out.println(pageSource);
        final String currentUrl = webDriver.getCurrentUrl();
        System.out.println(currentUrl);
    }
}
