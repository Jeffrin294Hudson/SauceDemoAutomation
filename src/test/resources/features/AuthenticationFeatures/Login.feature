Feature: User Login

  Scenario: Successful login with valid credentials
    Given I am on the SauceDemo login page
    When I enter "standard_user" as username
    And I enter "secret_sauce" as password
    And Click the login button
    Then It should display the products page

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the SauceDemo login page
    When I enter "invalid_user" as username
    And I enter "invalid_password" as password
    And Click the login button
    Then It should give an error message