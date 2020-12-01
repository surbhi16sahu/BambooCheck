package cukes_runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, monochrome = true, features = "Resources/Feature/SampleReport.feature", glue = "step_definition", tags = {
		"@ReportGeneration" }, plugin = { "pretty", "html:target/cucumber-reports", "json:target/cucumber.json" })
public class runner {

}