package parallelRunTestNG;

import org.junit.Assert;

import com.pages.LoginPage;
import com.utils.WebDriverFactory;

import io.cucumber.java.en.*;


public class LoginPageSteps {
	
	private LoginPage loginPage; 
	
	
	@Given("^User is on Login Page$")
	public void user_is_on_login_page() {
		loginPage = new  LoginPage(WebDriverFactory.getDriver());
	}

	@When("^User compares the title of the page$")
	public void user_compares_the_title_of_the_page() {
	    
	}

	@Then("^The Page title should be (.*)$")
	public void the_page_title_should_be_login_my_store(String pageTitle) {
		String actualPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(actualPageTitle.equals(pageTitle));
	}

	@Then("^Forgot Your Password Link should be displayed$")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.verifyForgotPasswordLink());
	}

	@When("^User enter the username as (.*)$")
	public void user_enter_the_username(String userName) {
		loginPage.enterUsrename(userName);
	}

	@When("^User enters the password as (.*)$")
	public void user_enters_the_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("^User clicks the login button$")
	public void user_clicks_the_login_button() throws InterruptedException {
		loginPage.clickSignin();
	}

	@Then("^User should be landing on the Home Page$")
	public void user_should_be_landing_on_the_home_page() {
	    
	}

	@Then("^The home page title should be (.*)$")
	public void the_page_title_should(String pageTitle) {
		String actualHomepageTitle = loginPage.getHomepageTitle();
		Assert.assertTrue(actualHomepageTitle.equals(pageTitle));
	}

}
