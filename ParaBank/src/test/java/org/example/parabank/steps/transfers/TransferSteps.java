package org.example.parabank.steps.transfers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.parabank.hooks.Hooks;
import org.example.parabank.pages.HomePage;
import org.example.parabank.pages.OpenNewAccountPage;
import org.example.parabank.pages.RegisterPage;
import org.example.parabank.pages.TransferFundsPage;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.parabank.utils.LoggerUtils.getLogger;

public class TransferSteps {
    private WebDriver driver = Hooks.driver;
    private String URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
    private String accountNumber;
    private OpenNewAccountPage openNewAccountPage;
    private TransferFundsPage transferFundsPage;
    private RegisterPage registerPage;
    private HomePage homePage;
    private String newAccountNumber;


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
        this.newAccountNumber = openNewAccountPage.getNewAccountNumber();
        openNewAccountPage.waitForTitle();
        String actualText = openNewAccountPage.isTextPresent();
        String expectedText = "Account Opened!";
        assertThat(actualText).contains(expectedText);
    }

    @Given("user is on the ParaBank transfer page")
    public void userIsOnTheParaBankTransferPage() {
        transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.clickOnTransferFundsLink();
    }

    @When("user selects the amount of the transfer, from account and to account {string}")
    public void userSelectsTheAmountOfTheTransferFromAccountAndToAccount(String amount) {
        transferFundsPage.transferAmount(amount);
        transferFundsPage.selectFromAccount();
        transferFundsPage.selectToAccount(newAccountNumber);
    }

    @And("click the transfer button")
    public void clickTheTransferButton() {
        transferFundsPage.clickTransfer();
    }

    @Then("user receive the confirmation message")
    public void userReceiveTheConfirmationMessage() {
        transferFundsPage.waitForConfirmationMessage("Transfer Complete!", 10);
        String actualText = transferFundsPage.isTextPresent();
        String expectedText = "Transfer Complete!";
        assertThat(actualText).contains(expectedText);
    }
}
