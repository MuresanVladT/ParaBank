package org.example.parabank.steps.register;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.parabank.hooks.Hooks;
import org.example.parabank.pages.HomePage;
import org.example.parabank.pages.RegisterPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.LoggerUtils.getLogger;

public class RegisterSteps {
    private WebDriver driver = Hooks.driver;
    private String URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
    private RegisterPage registerPage;
    private HomePage homePage;

    @Given("user is on the ParaBank's registering page")
    public void userIsOnTheParaBankSRegisteringPage() {
        getLogger().info("Start test");
        driver.get(URL);
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        registerPage.clickRegisterLink();
    }

    @When("user enters valid credentials for register {string} {string} {string} {string} {string} {string} {string}")
    public void userEntersValidCredentialsForRegister(String address, String city, String state, String zipCode, String phone, String ssn, String password) {
        registerPage.enterFirstName(RegisterPage.generateUniqueFirstName());
        registerPage.enterLastName(RegisterPage.generateUniqueLastname());
        registerPage.enterAddress(address);
        registerPage.enterCity(city);
        registerPage.enterState(state);
        registerPage.enterZipCode(zipCode);
        registerPage.enterPhoneNr(phone);
        registerPage.enterSSN(ssn);
        registerPage.enterUsername(RegisterPage.generateUniqueUsername());
        registerPage.enterPassword(password);
        registerPage.confirmPassword(password);
        registerPage.clickRegisterButton();
    }


    @Then("user is registered")
    public void userIsRegistered() {
        String actualText = registerPage.isTextPresent();
        String expectedText = "Your account was created successfully. You are now logged in.";
        assertThat(actualText).contains(expectedText);
    }

}
