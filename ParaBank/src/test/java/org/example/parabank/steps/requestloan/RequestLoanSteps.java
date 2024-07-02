package org.example.parabank.steps.requestloan;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.parabank.hooks.Hooks;
import org.example.parabank.pages.HomePage;
import org.example.parabank.pages.LoanPage;
import org.example.parabank.pages.RegisterPage;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.parabank.utils.LoggerUtils.getLogger;

public class RequestLoanSteps {
    private WebDriver driver = Hooks.driver;
    private String URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoanPage loanPage;

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

    @Given("user is on the RequestLoan page")
    public void userIsOnTheRequestLoanPage() {
        loanPage = new LoanPage(driver);
        loanPage.clickRequestLoanLink();
    }

    @When("user enters desired loan amount, down payment and fromAccount {string}, {string}")
    public void userEntersDesiredLoanAmountDownPaymentAndFromAccount(String loanAmount, String downPayment) {
        loanPage.enterLoanAmount(loanAmount);
        loanPage.enterDownPayment(downPayment);
        loanPage.selectFromAccount();
    }

    @And("click Apply Now button")
    public void clickApplyNowButton() {
        loanPage.clickApplyNow();
    }

    @Then("the loan request is processed, Status:Approved")
    public void theLoanRequestIsProcessedStatusApproved() {
        loanPage.waitForLoanStatus("Approved", 10);
        String actualText = loanPage.isTextPresent();
        String expectedText = "Approved";
        assertThat(actualText).contains(expectedText);
    }
}
