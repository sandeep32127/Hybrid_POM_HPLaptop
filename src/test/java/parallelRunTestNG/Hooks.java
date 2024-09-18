package parallelRunTestNG;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.utils.ConfigReader;
import com.utils.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
 private ConfigReader configReader;
 private WebDriver driver;
 private WebDriverFactory driverFactory;
 
 @Before(value = "@Skip", order = 0)
 public void skipScenario(Scenario sc) {
	 System.out.println("SKIPPED Scanario is ---"+sc.getName());
	 Assume.assumeTrue(false);
 }
 @Before(order = 1)
 public void before() {
	 configReader = new ConfigReader();
	 driverFactory = new WebDriverFactory();
	 driver = driverFactory.init_Driver(configReader.getProperty("browser"));
 }
 
 @After(order= 0)
 public void after() {
	 driver.quit();
 }
 
 @After(order= 1)
 public void takeScreenshot(Scenario sc) {
	 if(sc.isFailed()) {
		 String screenShotName = sc.getName().replaceAll(" ", "_");
		 byte[] screenshotPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 sc.attach(screenshotPath, "image/png", screenShotName);
	 }
 }
}
