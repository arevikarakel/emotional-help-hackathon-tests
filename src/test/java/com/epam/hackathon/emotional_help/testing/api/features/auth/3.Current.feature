Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to cover all functionality connected with current user
  Emotional Help Project Swagger URL: http://44.210.115.207:8080/swagger-ui/index.html

  Scenario: Get registered user's body and validate response body by jsonSchema
    When Register a random user
    Then Get registered user's body
    Then Status code should be 200
    Then Validate new registered user's response body by jsonSchema

  Scenario: New registered user's response body encrypt password
    When Register a random user
    Then Get registered user's body
    Then Status code should be 200
    Then New registered user's response body encrypt password
