Feature: Login in Customer site

  @login-01
  Scenario: Verify Login success with valid username and password, go to page by link
    Given Go to "signInPage" url
    When Insert email into box have id: email
    And Insert password into box have id: pass
    And Click button by id "send2"
    Then Successfully into myAccountPageExpect front site
  @login-02
  Scenario: Login with invalid account
    Given Go to "signInPage" url
    When Insert wrongEmail into box have id: email
    And Insert wrongPassword into box have id: pass
    And Click button by id "send2"
    Then Show error message for class message-error blank: The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.
  @login-03
  Scenario: Login with  wrong password
    Given Go to "signInPage" url
    When Insert email into box have id: email
    And Insert wrongPassword into box have id: pass
    And Click button by id "send2"
    Then Show error message for class message-error blank: The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.
  @login-04
  Scenario: Verify Login success with valid username and password, go to page by button login/Sign in
    Given Go to "glamiraUrl" url
    And Click button by class "authorization-text" 
#    button login/Sign in
    When Insert email into box have id: email
    And Insert password into box have id: pass
    And Click button by id "send2"
    Then Successfully into myAccountPageExpect front site