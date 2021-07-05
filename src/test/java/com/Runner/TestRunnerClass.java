package com.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features= "src\\test\\java\\Feature\\FacebookLogin.feature", 
                     glue= {"com.StepDefinition"})

public class TestRunnerClass {

	
	
	
}
