Feature: Add Intern
  Background:
    Given a successful Login
  Scenario: Add a Valid intern
    When I click on Add a new Intern
    And I enter a valid Intern data
    | civilValue | lastName |firstName | address | birthDate | birthCountry | birthCity | company | email | phone | lastNameAr | firstNameAr | birthCityAr |
    |"M"        | "Zouambia" | "Sohaib" |"Medea" |"2001-10-15"| "USA"      |"New York" | "11"    |"js_zouambia@esi.dz"|"05134891711"|"بروثن"|"كمال"| "المدية"|
    And click Submit
    Then The Intern should be added


