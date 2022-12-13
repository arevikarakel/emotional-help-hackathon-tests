Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to cover all functionality connected with advice
  Emotional Help Project Swagger URL: http://44.210.115.207:8080/swagger-ui/index.html

  Background:
    Given Setup Rest Assured

  Scenario Outline: Get advise by feelings
    When Get advise by "<feelings>"
    Then Status code should be 200
    And Validate advise response body by jsonSchema
    Then Validate that response tip and video is not empty
    Examples:
      | feelings |
      | HAPPY    |
      | SADNESS  |
      | JOY      |
      | FEAR     |
      | ANGRY    |
      | SURPRISE |




