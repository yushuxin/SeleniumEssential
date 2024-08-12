package org.example.ex07;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SauceLabsExample {

    public static void main(String[] args) throws Exception {

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("macOS 10.12");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-shuxin.yu.2024-d6228");
        sauceOptions.put("accessKey", "6c699a64-4fe9-419a-835e-8c607b6b8534");
        sauceOptions.put("build", "selenium-build-7IUU7");
        sauceOptions.put("name", "chrome test 1");
        browserOptions.setCapability("sauce:options", sauceOptions);

        // start the session
        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

        // run commands and assertions
        driver.get("https://saucedemo.com");
        String title = driver.getTitle();
        boolean titleIsCorrect = title.contains("Swag Labs");
        String jobStatus = titleIsCorrect ? "passed" : "failed";

        // end the session
        driver.executeScript("sauce:job-result=" + jobStatus);

        driver.quit();
    }
}