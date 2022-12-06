Feature: API tests for Emotional Help Project
  Description: The purpose of these test is to cover all functionality connected with questionnaire

  Scenario:Find user's emotional-map
    Given Setup Rest Assured
    When Get existing user's emotional-map
    Then Status code should be 200

  Scenario Outline:Check nonexistent user's emotional map's response status code
    Given Setup Rest Assured
    When Get <nonExistentUsers> emotional-map response body
    Then Status code should be 404
    Then Validate nonExistent users emotional map response error message
    Examples:
      | nonExistentUsers |
      | -1               |
      | err              |
      | 0                |
      | }                |
      | #                |
      | ^                |

  Scenario: Save emotional-map
