package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
	
	private WebDriver driver;
	
	@FindBy(css = "#center_column .myaccount-link-list span")
	private List<WebElement> lstSections;
	
	public AccountsPage(WebDriver driverAccountsPage ) {
		this.driver = driverAccountsPage;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public List<String> getSectionDetails() {
		List<String> sections = new ArrayList<String>();
		for (WebElement e : lstSections) {
			sections.add(e.getText().trim());
		}
		
		System.out.println("The actual sections list is : " +sections);
		
		return sections;
	}
	
	
	public int getSectionsCount() {
		return lstSections.size();
	}

}
