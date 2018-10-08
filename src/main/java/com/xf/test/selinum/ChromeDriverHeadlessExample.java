package com.xf.test.selinum;

/**
 * Created by xuefeng on 2018/10/08.
 * 谷歌无头浏览器
 */

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;


public class ChromeDriverHeadlessExample {

    public static void main(String[] args) throws IOException {
        final String chromeDriverPath = ChromeDriverHeadlessExample.class.getClassLoader().getResource("driver/chromedriver").getPath();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screenshot.png"));


        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }
}
