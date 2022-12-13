Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to cover all functionality connected with login
  Emotional Help Project Swagger URL: http://44.210.115.207:8080/swagger-ui/index.html

  Background:
    Given Setup Rest Assured

  Scenario: Test user's login API
    When Login with random user's credentials
    Then Status code should be 200

  Scenario Outline: Test user's login with invalid credentials
    When Login with invalid "<username>" and "<password>"
    Then Status code should be 409
    Then Validate invalid credentials login response messages
    Examples:
      | username | password |
      | Test     | Test     |
      | Test     |          |
      |          | Test     |
      | MExEsss  |          |





