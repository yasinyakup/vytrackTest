
@login
Feature:login feature

  Scenario: login to zero_bank application
    Given the user is on the login page
    When enter "username" and "password" and click submit
    Then the user should login and display "username"



  Scenario Outline: login to zero_bank application with bad credentials
    Given the user is on the login page
    When enter "<username>" and "<password>" and click submit
    Then the main page should display "<errorMessage>"
    Examples:
      |username  | password|errorMessage|
      | user1    | pass1  |Login and/or password are wrong.|
      | user2    | pass2  |Login and/or password are wrong.|
      | user10   | pass10 |Login and/or password are wrong.|
      | user11   | pass11 |Login and/or password are wrong.|
      | user99   | pass99 |Login and/or password are wrong.|
