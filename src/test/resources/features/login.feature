
@login
Feature:login feature

Scenario: login to zero_bank application
Given: the user is on the login page
When enter "username" and "password"
And click the login button
Then the user should login and display "username"
