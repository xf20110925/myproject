package com.xf.test.selinum;

/**
 * Created by xuefeng on 2017/7/29.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ChromeDriverExample {

    public static void main(String[] args) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/xuefeng/Downloads/soft/chromedriver");
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setJavascriptEnabled(true);
        // Disable "web-security", enable all possible "ssl-protocols" and "ignore-ssl-errors" for PhantomJSDriver
        WebDriver driver = new ChromeDriver(capabilities);
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }
}
