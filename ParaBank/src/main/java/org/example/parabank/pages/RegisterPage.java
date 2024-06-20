package org.example.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String firstName){
        WebElement firstNameField = driver.findElement(By.xpath("//input[@name=\"customer.firstName\"]"));
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        WebElement lastNameField = driver.findElement(By.xpath("//input[@name=\"customer.lastName\"]"));
        lastNameField.sendKeys(lastName);
    }

    public void enterAddress(String address){
        WebElement addressField = driver.findElement(By.xpath("//input[@name=\"customer.address.street\"]"));
        addressField.sendKeys(address);
    }

    public void enterCity(String city){
        WebElement cityField = driver.findElement(By.xpath("//input[@name=\"customer.address.city\"]"));
        cityField.sendKeys(city);
    }

    public void enterState(String state){
        WebElement stateField = driver.findElement(By.xpath("//input[@name=\"customer.address.state\"]"));
        stateField.sendKeys(state);
    }

    public void enterZipCode(String zipCode){
        WebElement zipCodeField = driver.findElement(By.xpath("//input[@name=\"customer.address.zipCode\"]"));
        zipCodeField.sendKeys(zipCode);
    }

    public void enterPhoneNr(String phoneNr){
        WebElement phoneNrField = driver.findElement(By.xpath("//input[@name=\"customer.phoneNumber\"]"));
        phoneNrField.sendKeys(phoneNr);
    }

    public void enterSSN(String ssn){
        WebElement ssnField = driver.findElement(By.xpath("//input[@name=\"customer.ssn\"]"));
        ssnField.sendKeys(ssn);
    }

    public void enterUsername(String username){
        WebElement usernameField = driver.findElement(By.xpath("//input[@name=\"customer.username\"]"));
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement passwordField = driver.findElement(By.xpath("//input[@name=\"customer.password\"]"));
        passwordField.sendKeys(password);
    }

    public void confirmPassword(String password){
        WebElement confirmField = driver.findElement(By.xpath("//input[@name=\"repeatedPassword\"]"));
        confirmField.sendKeys(password);
    }

    public void clickRegisterButton(){
        WebElement registerButton = driver.findElement(By.xpath("//input[@value=\"Register\"]"));
        registerButton.click();
    }

    public static String generateUniqueUsername(){
        return "user" + new Date().getTime();
    }

    public static String generateUniqueFirstName(){
        return "first" + new Date().getTime();
    }

    public static String generateUniqueLastname(){
        return "last" + new Date().getTime();
    }

    public String isTextPresent(){
        WebElement text = driver.findElement(By.xpath("//*[@id='rightPanel']/p[1]"));
        return text.getText();
    }
}
