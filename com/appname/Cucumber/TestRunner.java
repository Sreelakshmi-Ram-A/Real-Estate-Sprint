package com.appname.Testcase;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;


@CucumberOptions( glue = {"StepDefs"}, 
				  plugin = {"html:target/cucumber-reports/StepDefinitionLogin/cucumber-pretty","json:target/json-cucumber-reports/StepDefinitionLogin/cukejson.json",
		"testng:target/xmlreports/StepDefinitionLogin.xml" }, 
				  features = {"com/appname/Cucumber/Login.feature"}
				 
			    )

public class TestRunner extends AbstractTestNGCucumberTests {
	
	
}