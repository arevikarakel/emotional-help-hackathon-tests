Feature: UI tests for Emotional Help Project

  Scenario: Registering a new user
    Given I am on the registration page
    When I register a new user
    Then The home page is displayed