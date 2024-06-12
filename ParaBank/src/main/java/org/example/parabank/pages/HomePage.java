package org.example.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username){
        WebElement usernameField = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement passwordField = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passwordField.sendKeys(password);
    }

    public void clickLogIn(){
        WebElement loginButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        loginButton.click();
    }

    public String isTextPresent(){
        WebElement text = driver.findElement(By.xpath("//p[contains(@class, 'error')]"));
        return text.getText();
    }
}
