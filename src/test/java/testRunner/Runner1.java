package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"FeatureFiles"},tags={"@tag1"},monochrome=true,glue={"stepDefinitions"},plugin={"com.cucumber.listener.ExtentCucumberFormatter:Reports/login.html","pretty", "html:target/cucumber-reports"})
public class Runner1 {

}
