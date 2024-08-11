package org.example.ex0601;

import org.example.ex0601.pages.ConfirmationPage;
import org.example.ex0601.pages.FormPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Form {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage(driver);
        formPage.submitForm();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.waitForAlertBanner();

        assert "The form was successfully submitted!".equals(confirmationPage.getAlertBannerText());

        driver.quit();
    }

}
