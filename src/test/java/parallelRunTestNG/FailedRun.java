package parallelRunTestNG;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"@target/failedRun.txt"}, glue = {"parallelRunTestNG"},
plugin = {"pretty","rerun:target/failedRun.txt"},
publish = true)
@RunWith(Cucumber.class)
public class FailedRun  extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}
