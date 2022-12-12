Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to cover all functionality connected with questionnaires
  Emotional Help Project Swagger URL: http://44.210.115.207:8080/swagger-ui/index.html

  Background:
    Given Setup Rest Assured

  Scenario: Find an existing questionnaire
    When Get existing questionnaire
    Then Status code should be 200
    And Questionnaire has correct schema

  Scenario: Find a nonexistent questionnaire
    When Get nonexistent questionnaire
    Then Status code should be 404