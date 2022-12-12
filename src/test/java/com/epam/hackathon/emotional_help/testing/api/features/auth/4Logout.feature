Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to cover all functionality connected with logout
  Emotional Help Project Swagger URL: http://44.210.115.207:8080/swagger-ui/index.html

  Background:
    Given Setup Rest Assured

  Scenario: Sign-in user should be logout
    When User should be logout
    Then Status code should be 200
    Then Validate successful logout response message

  Scenario: Without token is not possible logout
    When Without token is not possible logout
    Then Status code should be 401