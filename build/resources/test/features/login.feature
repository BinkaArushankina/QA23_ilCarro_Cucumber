Feature: Login

  @validData
  Scenario: Login with valid data
    Given User launches browser
    When User opens ilCarro Home Page
    And User clicks on Log in link
    And User enters valid data
    And User clicks on Yalla button
    Then User verifies Log in message
    And User quits browser


  @wrongPassword
  Scenario Outline: Login with valid email and wrong password
    Given User launches browser
    When User opens ilCarro Home Page
    And User clicks on Log in link
    And User enters valid email and wrong password
      | email   | password   |
      | <email> | <password> |
    And User clicks on Yalla button
    Then User verifies error
    And User quits browser
    Examples:
      | email                      | password    |
      | albinarushankina@gmail.com | Bina12!     |
      | albinarushankina@gmail.com | binabina123   |
      | albinarushankina@gmail.com | BinabinaBina |
      | albinarushankina@gmail.com | 123123!!!   |