Feature: Login to Backend
  Background: Given go to the admin "adminPage"

  @loginAdmin-01
  Scenario: Login success
    Given Login "adminPage" with "accountAdmin" and "passWordAdmin"
    Then Successfully into ExpectDashboardPage front site
  @loginAdmin-02
  Scenario: Login with invalid account
    Given Login "adminPage" with "wrongEmail" and "wrongPassword"
    Then Show error message for class message-error blank: The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.
  @loginAdmin-03
  Scenario: Login with  wrong password
    Given Login "adminPage" with "accountAdmin" and "wrongPassword"
    Then Show error message for class message-error blank: The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.
