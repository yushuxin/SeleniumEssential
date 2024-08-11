package org.example.ex0203;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Autocomplete {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autoComplete = driver.findElement(By.id("autocomplete"));
        autoComplete.click();
        autoComplete.sendKeys("155 Park Blvd, Palo Alto, CA");
        Thread.sleep(1000);

        WebElement autoCompleteResult = driver.findElement(By.className("pac-item"));
        autoCompleteResult.click();

        driver.quit();
    }
}
