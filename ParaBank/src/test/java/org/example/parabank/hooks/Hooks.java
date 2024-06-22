package org.example.parabank.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.parabank.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    public static SeleniumUtils seleniumUtils;

    @Before
    public void setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.seleniumUtils = new SeleniumUtils(driver);

    }

    @After
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
