Feature: Cart Management

  Scenario: Adding multiple items to the cart
    Given I am logged in as "standard_user"
    When I add the following products to the cart
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    Then the cart should contain 3 item