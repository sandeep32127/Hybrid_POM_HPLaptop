Feature: Verify the Login Page functionality of Automation Practice

Scenario Outline: Validate the login page title
Given User is on Login Page
When User compares the title of the page
Then The Page title should be <pageTitle>
Examples:
|pageTitle|
|Login - My Store1|

Scenario: Validate the Forgot Your Password link
Given User is on Login Page
Then Forgot Your Password Link should be displayed

Scenario Outline: Validate the Login functionality with correct credentials
Given User is on Login Page
When User enter the username as <userName>
And User enters the password as <password>
And User clicks the login button
Then User should be landing on the Home Page
And The home page title should be <homePageTitle>
Examples:
|userName|password|homePageTitle|
|daleisandeep458@gmail.com|Sandeep@32127|My account - My Store|



