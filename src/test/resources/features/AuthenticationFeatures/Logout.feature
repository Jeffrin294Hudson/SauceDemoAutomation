Feature: User Logout

  Scenario: User Logging out
    Given I am logged in as "standard_user"
    When I click the menu button
    And Click the logout button
    Then It should be redirected to the login page