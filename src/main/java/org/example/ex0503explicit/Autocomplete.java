package org.example.ex0503explicit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Autocomplete {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("1555 Park Blvd, Palo Alto, CA");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement autocompleteResult = wait.until(
                                                ExpectedConditions.
                                                        visibilityOfElementLocated(By.className("pac-item")));

//        ExpectedConditions.elementToBeClickable()
//        ExpectedConditions.elementToBeSelected()
//        ExpectedConditions.presenceOfElementLocated()
//        ExpectedConditions.textToBePresentInElement()

        autocompleteResult.click();

        driver.quit();
    }
}
