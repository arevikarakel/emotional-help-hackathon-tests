Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to cover all functionality connected with saving emotional-map
  Emotional Help Project Swagger URL: http://44.210.115.207:8080/swagger-ui/index.html

  Background:
    Given Setup Rest Assured

  Scenario: Save new emotional-map for anonymous user who has none
    When Save new emotional-map for anonymous user who has none
    Then Status code should be 200
    Then Validate user's saved emotional-map response body by jsonSchema

  Scenario: Save new emotional-map for existing user who has none
    When Save new emotional-map for existing user who has none
    Then Status code should be 200
    Then Validate user's saved emotional-map response body by jsonSchema

  Scenario: Replace the saved emotional-map for anonymous user
    When Replace the saved emotional-map for anonymous user
    Then Status code should be 200
    Then Validate user's saved emotional-map response body by jsonSchema

  Scenario: Replace the saved emotional-map for existing user
    When Replace the saved emotional-map for existing user
    Then Status code should be 200
    Then Validate user's saved emotional-map response body by jsonSchema

  Scenario: Check replaced emotional-map's values for existing user
    When Save new emotional-map for existing user who has none
    When Replace the saved emotional-map for existing user
    Then Status code should be 200
    Then Check replaced emotional-map's values for existing user

  Scenario: Check replaced emotional-map's values for anonymous user
    When Save new emotional-map for anonymous user who has none
    When Replace the saved emotional-map for anonymous user
    Then Status code should be 200
    Then Check replaced emotional-map's values for anonymous user

  Scenario: Saving emotional-map for anonymous user without mark is not possible
    When Save new emotional-map for anonymous user without mark
    Then Status code should be 400




