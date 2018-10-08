package com.xf.test.selinum;

/**
 * Created by xuefeng on 2018/10/08.
 * 谷歌无头浏览器
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverHeadlessExample {

    public static void main(String[] args) {
        final String chromeDriverPath = ChromeDriverHeadlessExample.class.getClassLoader().getResource("driver/chromedriver").getPath();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }
}
