@login
Feature: Login to Backend
  @login-01
  Scenario: Login success
    Given go to the admin "adminPage"
    Given Login "adminPage" with "accountAdmin" and "passWordAdmin"
    Then I should  be on Admin Porfile pages
@login-02
Scenario: Login with invalid account
  Given go to the admin "adminPage"
  Given Login "adminPage" with "wrongAccountAdmin" and "passWordAdmin"
  Then I should not be on Admin Porfile pages
@login-02
Scenario: Login with  wrong password
  Given go to the admin "adminPage"
  Given Login "adminPage" with "accountAdmin" and "wrongPasswordAdmin"
  Then I should not be on Admin Porfile pages