package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features ="resources",
        glue = "StepDefinitions",
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"}
        ,tags = "@AddCustomer"
)

public class TestRunner
{

}
