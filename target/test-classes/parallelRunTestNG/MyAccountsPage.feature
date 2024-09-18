Feature: My ACcounts Page Testing

Background: 
Given User should have loggen in to application
|Username|Password|
|daleisandeep458@gmail.com|Sandeep@32127|

Scenario Outline: Verify the Accounts Page title
Given User is on Accounts Page
When User gets the title of the page
Then The Accounts page title should be <pageTitle>
Examples:
|pageTitle|
|My account - My Store|


Scenario: Verify the Accounts Section Details
Given User is on Accounts Page
Then User gets the Section Details
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
And The Accounts section count should be 5

