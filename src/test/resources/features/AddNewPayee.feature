@newpayee




Feature: Add new payee under pay bills

  Background: the user is logged in
    Given the user is on the login page
    When enter "username" and "password" and click submit
    Then the user should login and display "username"

  @main
  Scenario: Add a new payee
    Given Add New Payee tab
    And creates new payee using following information
      |Payee Name | The Law Offices of Hyde, Price & Scharks|
      |Payee Address | 100 Same st, Anytown, USA, 10001 |
      |Account | Checking |
      |Payee Details | XYZ account |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed