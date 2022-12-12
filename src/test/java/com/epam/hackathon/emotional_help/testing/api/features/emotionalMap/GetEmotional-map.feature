Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to cover all functionality connected with getting emotional-map
  Emotional Help Project Swagger URL: http://44.210.115.207:8080/swagger-ui/index.html

  Background:
    Given Setup Rest Assured

  Scenario:Get user's emotional map
    When Save new emotional-map for existing user who has none
    When Get existing user's emotional-map
    Then Status code should be 200
    Then Validate user's emotional-map response body by jsonSchema

  Scenario:Get emotional map without userId is not possible
    When Get emotional map without userId
    Then Status code should be 400

  Scenario Outline:Check nonexistent user's emotional map's response status code and error message
    When Get <nonExistentUsers> emotional-map response body
    Then Status code should be 404
    Then Validate nonExistent users emotional map response error message
    Examples:
      | nonExistentUsers |
      | -1               |
      | err              |
      | @#$              |
      | null             |
