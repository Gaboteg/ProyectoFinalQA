Feature: Homepage actions in OrangeHRM Demo
  Background: User login into OrangeHRM Demo page
    Given Im in OrangeHRM demo web page

  @LogoutRequired
  Scenario: Load My Info tab at OrangeHRM Demo page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on login button
    Then The home page should be displayed

    When I click on the My Info menu
    Then My Info menu should be displayed

  @LogoutRequired
  Scenario: Search an employee by name at OrangeHRM Demo page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on login button
    Then The home page should be displayed

    Given I put "Alice" in the name field
    And I click in the autocomplete suggestion
    When I click on the search button
    Then The ID "0221" should be the first result

  @LogoutRequired
  Scenario Outline: Search an employee by ID at OrangeHRM Demo page
    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on login button
    Then The home page should be displayed

    Given I set the id field to "<ids>"
    When I click on the search button
    Then The ID "<ids>" should be the first result
    Examples:
      | ids |
      |0221|