Feature: promotion campaign

  Scenario: discount on all products
    Given Login "adminPage" with "accountAdmin" and "passWordAdmin"
    And Go to "cartPriceRule"
    When Create a "percent" discount rule
    And Go to "itemDetail"
    And Click on "selectSizeButton" then select "selectSize"
    And Click button by id "addToCart"
    And Go to "theCart"
    Then The discount is "discountAmount"