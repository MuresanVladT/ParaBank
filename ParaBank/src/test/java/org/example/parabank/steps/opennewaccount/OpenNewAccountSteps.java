package org.example.parabank.steps.opennewaccount;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.parabank.hooks.Hooks;
import org.example.parabank.pages.OpenNewAccountPage;
import org.openqa.selenium.WebDriver;

import static org.example.parabank.utils.LoggerUtils.getLogger;
import static org.junit.Assert.assertEquals;

public class OpenNewAccountSteps {
    private WebDriver driver = Hooks.driver;
    private String URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
    private OpenNewAccountPage openNewAccountPage;


    @Given("user is on the ParaBank openNewAccount page")
    public void userIsOnTheParaBankOpenNewAccountPage() {
        getLogger().info("Start test");
        driver.get(URL);
        openNewAccountPage = new OpenNewAccountPage(driver);
        openNewAccountPage.clickOnOpenNewAccountLink();
    }

    @When("the user selects an account type {string}")
    public void theUserSelectsAnAccountType(String accountType) {
        openNewAccountPage.selectTypeOfAccount(accountType);
    }

    @And("selects the account from where to transfer money and open new account {string}")
    public void selectsTheAccountFromWhereToTransferMoneyAndOpenNewAccount(String transferAccount) {
        openNewAccountPage.selectFromWhatAccountToTransferMoney(transferAccount);
        openNewAccountPage.clickOpenNewAccount();
    }

    @Then("user creates a new account, the page title should be {string}")
    public void userCreatesANewAccountThePageTitleShouldBe(String expectedTitle) {
        String actualTitle = openNewAccountPage.getPageTitle();
        assertEquals(expectedTitle, actualTitle);
    }

}