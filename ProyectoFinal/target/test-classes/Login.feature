Feature: Login OrangeHRM Demo
  Background: User login into OrangeHRM Demo page
    Given Im in OrangeHRM demo web page

  @LogoutRequired
  Scenario: Login into OrangeHRM Demo page with valid credentials
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on login button
    Then The home page should be displayed


  Scenario: Login into OrangeHRM Demo page with invalid credentials
    Given I set the user name field with "Adm"
    And I set the password field with "admin321"
    When I click on login button
    Then An error message that says "Invalid credentials" is displayed


