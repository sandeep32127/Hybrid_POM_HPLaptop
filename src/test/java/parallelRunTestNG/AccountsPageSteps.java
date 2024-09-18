package parallelRunTestNG;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.utils.WebDriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(WebDriverFactory.getDriver());
	private AccountsPage accountsPage;
	String accountsPageTitle;
	
	@Given("User should have loggen in to application")
	public void user_should_have_loggen_in_to_application(DataTable userDetails) throws InterruptedException {
		List<Map<String, String>> userLoginData = userDetails.asMaps();
		String userName = userLoginData.get(0).get("Username");
		String password = userLoginData.get(0).get("Password");
		accountsPage = loginPage.loginToApplication(userName, password);
	}

	@Given("User is on Accounts Page")
	public void user_is_on_accounts_page() {
	   
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		accountsPageTitle = accountsPage.getAccountsPageTitle();
	}

	@Then("^The Accounts page title should be (.*)$")
	public void the_page_title_should_be_my_account_my_store(String pageTitle) {
	    Assert.assertTrue(accountsPageTitle.equals(pageTitle));
	}

	@Then("User gets the Section Details")
	public void user_gets_the_section_details(DataTable sectionDetails) {
		List<String> expectedSectionsList = sectionDetails.asList();
		System.out.println("The expected sections list is : "+expectedSectionsList);
		List<String> actualSectionsLis = accountsPage.getSectionDetails();
	    Assert.assertTrue(actualSectionsLis.containsAll(expectedSectionsList));
	}

	@Then("The Accounts section count should be {int}")
	public void the_accounts_section_count_should_be(int sectionNumber) {
		Assert.assertTrue(accountsPage.getSectionsCount() == sectionNumber);
	}

}
