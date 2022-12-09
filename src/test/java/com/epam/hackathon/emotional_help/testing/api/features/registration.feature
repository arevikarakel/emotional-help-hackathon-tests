Feature: Registration

  Scenario: Successful registration
    Given Setup Rest Assured
    When Register a user with valid data
    Then Status code should be 200
    And Returned user contains correct data