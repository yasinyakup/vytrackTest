@accountactivity

Feature: Navigating to specific accounts in Accounts Activity
  Background: the user is logged in
    Given the user is on the login page
    When enter "username" and "password" and click submit
    Then the user should login and display "username"


    @main
  Scenario Outline: link redirections
    When the user clicks on "<option>" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "<option>" selected
    Examples:

    |option     |
    |Savings    |
    |Brokerage  |
    |Checking   |
    |Credit Card|
    |Loan       |

