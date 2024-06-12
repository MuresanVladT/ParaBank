package org.example.parabank.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.parabank.hooks.Hooks;
import org.example.parabank.pages.HomePage;
import org.openqa.selenium.WebDriver;

import static org.example.LoggerUtils.getLogger;

public class LoginSteps {
    private WebDriver driver = Hooks.driver;
    private String URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
    private HomePage homePage;

    @Given("user is on the ParaBank login page")
    public void userIsOnTheParaBankLoginPage(){
        getLogger().info("Start test");
        driver.get(URL);
        homePage = new HomePage(driver);
    }

    @When("user enters valid credentials {string} {string}")
    public void userEntersValidCredentials(String username, String password) {
        homePage.enterUsername(username);
        homePage.enterPassword(password);
        homePage.clickLogIn();
    }

    @Then("user is logged in")
    public void userIsLoggedIn(){
    }

}
