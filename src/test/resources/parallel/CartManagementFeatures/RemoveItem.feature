Feature: Cart Management

  Scenario: Removing items from the cart
    Given I am logged in as "standard_user"
    And I have added the following products to the cart
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    When I remove the products from the cart
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    Then the cart should contain 1 item