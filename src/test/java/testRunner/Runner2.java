package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"FeatureFiles"},tags={"@tag2"},monochrome=true,glue={"stepDefinitions"},plugin={"com.cucumber.listener.ExtentCucumberFormatter:Reports/login2.html","pretty", "html:target/cucumber-reports2"})
public class Runner2 {

}
