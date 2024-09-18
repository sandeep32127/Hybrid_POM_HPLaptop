package parallelRunTestNG;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(features = {"src/test/resources/parallelRunTestNG/LoginPage.feature"}, glue = {"parallelRunTestNG"},
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/",
		"rerun:target/failedRun.txt"}, //tags = "not @Skip",
publish = true)
@RunWith(Cucumber.class)
public class ParallelRun extends AbstractTestNGCucumberTests{
	
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}