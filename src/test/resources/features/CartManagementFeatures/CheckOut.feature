Feature: Cart Management

  Scenario: Unsuccessful checkout due to missing information
    Given I am logged in as "standard_user"
    And I have added the following products to the cart
      | Sauce Labs Bolt T-Shirt |
    When I proceed to checkout
    And I enter the following information:
      | firstName | lastName | postalCode |
      |           | Doe      |      12345 |
    And Click the "Continue" button
    Then It should display an error message indicating that "Error: First Name is required"

  Scenario: Successful checkout
    Given I am logged in as "standard_user"
    And I have added the following products to the cart
      | Sauce Labs Bolt T-Shirt |
    When I proceed to checkout
    And I enter the following information:
      | firstName | lastName | postalCode |
      | John      | Doe      |      12345 |
    And Click the "Continue" button
    And Complete the payment
    Then It should display a confirmation message "Thank you for your order!"
