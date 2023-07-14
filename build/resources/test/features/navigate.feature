Feature: Home Page

  @navigate
  Scenario: Verify Home Page Title is displayed
    Given User launches browser
    When User opens ilCarro Home Page
    Then User verifies Home Page title
    And User quits browser