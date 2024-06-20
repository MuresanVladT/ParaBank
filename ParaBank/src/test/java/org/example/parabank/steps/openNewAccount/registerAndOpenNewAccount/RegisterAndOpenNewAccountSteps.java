package org.example.parabank.steps.openNewAccount.registerAndOpenNewAccount;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.example.parabank.hooks.Hooks;
import org.example.parabank.pages.HomePage;
import org.example.parabank.pages.OpenNewAccountPage;
import org.example.parabank.pages.RegisterPage;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.parabank.utils.LoggerUtils.getLogger;
import static org.junit.Assert.assertEquals;

public class RegisterAndOpenNewAccountSteps {
    private WebDriver driver = Hooks.driver;
    private String URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
    private String accountNumber;
    private OpenNewAccountPage openNewAccountPage;
    private RegisterPage registerPage;
    private HomePage homePage;

    @Given("user is on the ParaBank registration page")
    public void userIsOnTheParaBankSRegisteringPage() {
        getLogger().info("Start test");
        driver.get(URL);
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
        homePage.clickRegisterLink();
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

    @Given("user is on the ParaBank openNewAccount page")
    public void userIsOnTheParaBankOpenNewAccountPage() {
        openNewAccountPage = new OpenNewAccountPage(driver);
        openNewAccountPage.clickOnOpenNewAccountLink();
    }

    @When("the user selects an account type {string}")
    public void theUserSelectsAnAccountType(String accountType) {
        openNewAccountPage.selectTypeOfAccount(accountType);
    }

    @And("selects the account from where to transfer money and open new account")
    public void selectsTheAccountFromWhereToTransferMoneyAndOpenNewAccount() {
        openNewAccountPage.selectFromWhatAccountToTransferMoney(accountNumber);
        openNewAccountPage.clickOpenNewAccount();
    }

    @Then("user creates a new account")
    public void userCreatesANewAccount() {
        String actualText = openNewAccountPage.isTextPresent();
        String expectedText = "Account Opened!";
        Assertions.assertThat(actualText).contains(expectedText);
    }

    @Then("user creates a new account, the page title should be {string}")
    public void userCreatesANewAccountThePageTitleShouldBe(String expectedTitle) {
        String actualTitle = openNewAccountPage.getPageTitle();
        assertEquals(expectedTitle, actualTitle);
    }
}
