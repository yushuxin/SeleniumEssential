package org.example.ex0205;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToActiveWindow {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");

//        driver.switchTo().window("windowHandle");
//        driver.switchTo().frame("frameName");
//        driver.switchTo().alert();

        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();
        String originalHandle = driver.getWindowHandle();
        for (String handle1: driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
        }

        driver.switchTo().window(originalHandle);

        driver.quit();
    }
}
