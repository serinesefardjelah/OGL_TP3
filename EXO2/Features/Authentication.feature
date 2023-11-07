Feature: Authentication
  Background:
    Given the web page

  Scenario: valid authentication
    When i enter "nabil" and "test"
    And I submit the form
    Then i should access the page


  Scenario: non valid authentication
    When i enter "nabil" and "nabil"
    And I submit the form
    Then i should not access the page
