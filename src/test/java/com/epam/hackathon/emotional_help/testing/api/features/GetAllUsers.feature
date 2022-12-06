Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to get all users

  Scenario: Find all users
    Given Setup Rest Assured
    When Get all users
    Then Status code should be 200