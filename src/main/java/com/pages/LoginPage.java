package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	
	@FindBy(id = "email")
	private WebElement fieldUserName;
	
	@FindBy(id = "passwd")
	private WebElement fieldPassword;
	
	@FindBy(id = "SubmitLogin")
	private WebElement btnSignIn;
	
	@FindBy(linkText = "Forgot your password?")
	private WebElement lnkForgotPassword;
	
	
	public LoginPage(WebDriver driverLogin) {
		this.driver = driverLogin;
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean verifyForgotPasswordLink() {
		return lnkForgotPassword.getText().equalsIgnoreCase("Forgot your password?");
	}
	
	public void enterUsrename(String userName) {
		fieldUserName.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		fieldPassword.sendKeys(password);
	}
	
	public void clickSignin() throws InterruptedException {
		
		btnSignIn.click();
		Thread.sleep(5000);
	}
	
	public String getHomepageTitle() {
		return driver.getTitle();
	}
	
	public AccountsPage loginToApplication(String userName, String password) throws InterruptedException {
		enterUsrename(userName);
		enterPassword(password);
		clickSignin();
		return new AccountsPage(driver);
	}
}
