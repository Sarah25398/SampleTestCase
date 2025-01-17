Feature: Login Functionality

  Scenario: Successful Login
    Given I navigate to the login page
    When I enter valid credentials
    Then I should see the dashboard
