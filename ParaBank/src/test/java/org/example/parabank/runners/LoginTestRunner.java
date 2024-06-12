package org.example.parabank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/example/parabank/features/login",
        glue = {"org.example.parabank.steps.login", "org.example.parabank.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class LoginTestRunner {
}
