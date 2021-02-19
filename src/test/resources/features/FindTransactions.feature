@findtrsaction
Feature: Find Transactions in Account Activity

  Background: the user is logged in
    Given the user is on the login page
    When enter "username" and "password" and click submit
    Then the user should login and display "username"
  @main @find1 @l1
  Scenario: Search date range
    Given the user accesses the Find Transactions tab
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the results should be sorted by most recent date

  @main @find1
  Scenario: Search and not include prior dates
    Given the user accesses the Find Transactions tab
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"
  @main
  Scenario: Search description
    Given the user accesses the Find Transactions tab
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And clicks search
    Then results table should only show descriptions containing "OFFICE"
    But results table should not show descriptions containing "ONLINE"
  @main
  Scenario: Search description case insensitive
    Given the user accesses the Find Transactions tab
    When the user enters description "ONLINE"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "online"
    And clicks search
    Then results table should only show descriptions containing "ONLINE"
  @main @find2
  Scenario: Type
    Given the user accesses the Find Transactions tab
    And clicks search
    Then results table should show at least one result under Deposit
    Then results table should show at least one result under Withdrawal
    When user selects type "Deposit"
    Then results table should show at least one result under Deposit
    But results table should show no result under Withdrawal
    When the user accesses the Find Transactions tab
    And user selects type "Withdrawal"
    Then results table should show at least one result under Withdrawal
    But results table should show no result under Deposit