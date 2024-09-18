package com.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"}, glue = {"com.stepdifinitions","com.hooks"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"},
publish = true)
@RunWith(Cucumber.class)
public class TestRunner {

}
