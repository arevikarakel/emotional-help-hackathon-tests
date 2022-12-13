Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to cover all functionality connected with registration
  Emotional Help Project Swagger URL: http://44.210.115.207:8080/swagger-ui/index.html

  Background:
    Given Setup Rest Assured

  Scenario: Register a random user with valid data
    When Register a random user
    Then Status code should be 200

  Scenario: User with existing username is not able to register
    When Check registration fail if username existing
    Then Status code should be 409
    Then Validate existing username error message

  Scenario: User with existing email is not able to register
    When Check registration fail if email is existing
    Then Status code should be 409
    Then Validate existing email error message

  Scenario: User with password which is less than 7 characters is not able to register
    When Check registration fail if password less than seven character
    Then Status code should be 409
    Then Validate invalid password error message