Feature: UI tests for Emotional Help Project

  Scenario: Changing to the next question
    Given I am on the home page
    When I start the self-test
    And I choose an answer
    Then The next question is displayed

  Scenario: Taking a complete self-test
    Given I am on the home page
    When I start the self-test
    And I choose an answer for all the questions
    Then The results diagram is displayed
    And A link to a helpful video is displayed
    And Helpful tips are displayed

