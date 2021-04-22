Feature: The cart page

  Background: An item is added into the cart
    Given Go to "itemDetail"
    When Click on "selectSizeButton" then select "selectSize"
    And Click button by id "addToCart"
    And Click accept cookie

  Scenario: Add two similar products into the cart
    Given Go to "itemDetail"
    When Click on "selectSizeButton" then select "selectSize"
    And Click button by id "addToCart"
    And Click button by class "miniCart"
    Then Successfully into myCartExppect front site
    And The current quantity is "2"

  Scenario: Change the quantity in the cart
    Given Go to "theCart"
    When input "3" to change quantity of product in cart
    And Wait about 30 seconds
#    And Click button by class "acceptToChange"
    Then The subTotalPrice is "changedPrice"
#    pls change price expect in data.properties if you change quantity of product
# fail :
#  Expect: change qty successfully
#  Actual: delete the item in cart
  Scenario: Add another item into the cart
    Given  Go to "anotherItemDetail"
    When Click on "selectSizeButton" then select "selectSize"
    And Click button by id "addToCart"
    And Wait about 30 seconds
    And Click button by class "miniCart"
    Then The totalPrice is "newTotalPrice"
#    pls change price expect in data.properties if you change another product

  Scenario: Remove an item from the cart
    Given Go to "theCart"
    When Click on removedBtn
    Then The shoping bag is empty
