package org.example.parabank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/example/parabank/features",
        glue = {"org.example.parabank.steps", "org.example.parabank.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner {
}
