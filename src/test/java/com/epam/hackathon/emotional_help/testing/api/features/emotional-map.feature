Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to cover all functionality connected with emotional-map
  Emotional Help Project Swagger URL: http://44.210.115.207:8080/swagger-ui/index.html

  Background:
    Given Setup Rest Assured

  Scenario: Save emotional-map for anonymous user
    When Save emotional-map for anonymous user
    Then Status code should be 200
    Then Validate user's saved emotional-map response body by jsonSchema

  Scenario: Check saved user's emotional-map's values
    When Save emotional-map for anonymous user
    Then Status code should be 200
    Then Check saved user's emotional-map value

  Scenario:Get user's emoyional map
    When Get existing user's emotional-map
    Then Status code should be 200
    Then Validate user's emotional-map response body by jsonSchema


  Scenario Outline:Check nonexistent user's emotional map's response status codeand error message
    When Get <nonExistentUsers> emotional-map response body
    Then Status code should be 404
    Then Validate nonExistent users emotional map response error message
    Examples:
      | nonExistentUsers |
      | -1               |
      | err              |
      | 0                |
      | @#$              |
      | null             |




