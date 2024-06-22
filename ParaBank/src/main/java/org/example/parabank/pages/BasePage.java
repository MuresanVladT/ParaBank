package org.example.parabank.pages;

import org.example.parabank.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SeleniumUtils seleniumUtils;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.seleniumUtils = new SeleniumUtils(driver);
        PageFactory.initElements(driver, this);
    }
}
