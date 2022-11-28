Feature: UI tests for Emotional Help Project

  Scenario: Do a Google search
    Given We are on the Google home page
    When We enter text into the search field and submit it
    Then The search results page is displayed