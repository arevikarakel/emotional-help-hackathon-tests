Feature: UI tests for Emotional Help Project

  Scenario: Choosing an answer

  Scenario: Taking a complete self-test
    Given I am on the home page
    When I start the self-test
    And I choose an answer for all the questions
    Then The results diagram is displayed
    And A link to a helpful video is displayed
    And Helpful tips are displayed

