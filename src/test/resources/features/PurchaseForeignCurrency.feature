@purchacecurrency
Feature: Purchase Foreign Currency

  Background: the user is logged in
    Given the user is on the login page
    When enter "username" and "password" and click submit
    Then the user should login and display "username"

    @main
  Scenario: Available currencies
    Given the user accesses the Purchase foreign currency cash tab
    Then following currencies should be available
      |Australia (dollar) |
      |Canada (dollar) |
      |Switzerland (franc) |
      |China (yuan) |
      |Denmark (krone) |
      |Eurozone (euro) |
      |Great Britain (pound)|
      |Japan (yen) |
      |Mexico (peso) |
      |Norway (krone) |
      |New Zealand (dollar) |
      |Singapore (dollar) |
  @main
  Scenario: Error message for not selecting currency
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed
  @main
  Scenario: Error message for not entering value
    Given the user accesses the Purchase foreign currency cash tab
    When user tries to calculate cost without entering a value
    Then error message should be displayed