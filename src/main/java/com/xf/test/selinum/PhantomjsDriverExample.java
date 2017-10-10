package com.xf.test.selinum;

/**
 * Created by xuefeng on 2017/7/29.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;

public class PhantomjsDriverExample {

    public static void main(String[] args) {
        final DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/Users/xuefeng/Downloads/soft/phantomjs-2.1.1-macosx/bin/phantomjs");
        // Disable "web-security", enable all possible "ssl-protocols" and "ignore-ssl-errors" for PhantomJSDriver
        ArrayList<String> cliArgsCap = new ArrayList<>();
        cliArgsCap.add("--web-security=false");
        cliArgsCap.add("--ssl-protocol=any");
        cliArgsCap.add("--ignore-ssl-errors=true");
        cliArgsCap.add("--disk-cache=true");
        cliArgsCap.add("--max-disk-cache-size=1000000");
        cliArgsCap.add("--load-images=true");
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
                cliArgsCap);
        // Control LogLevel for GhostDriver, via CLI arguments
        capabilities.setCapability(
                PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS,
                new String[]{"--logLevel=", "INFO"});

        WebDriver driver = new PhantomJSDriver(capabilities);
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }
}
