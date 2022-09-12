Feature: Logout OrangeHRM Demo
  Background: User logout from OrangeHRM Demo page
    Given Im in OrangeHRM demo web page

  Scenario: Logout from OrangeHRM Demo page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on login button
    Then The home page should be displayed

    Given I click in the user banner
    When I click o the logout option
    Then The login page should be displayed
