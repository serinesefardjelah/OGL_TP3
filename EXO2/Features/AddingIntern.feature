Feature: Adding an Intern
  Background:
    Given a successful login
  Scenario: Add a valid Intern
    When I click on Add a new Intern.
    And I enter a valid Intern data.
      | civilValue | lastName |firstName | address | birthDate | birthCountry | birthCity | company | email | phone | lastNameAr | firstNameAr | birthCityAr |
      |M      | Zouambia | Sohaib |Medea |2001-10-15| USA      |New York | 11    |js_zouambia@esi.dz|05134891711|بروثن|كمال|المدية|
    And I click Submit
    Then The Intern should be added with success

  Scenario: Add a non valid Intern
    When I click on Add a new Intern.
    And I enter a non valid Intern data.
      | civilValue | lastName |firstName | address | birthDate | birthCountry | birthCity | company | email | phone | lastNameAr | firstNameAr | birthCityAr |
      |M      |[blank]|[blank] |Medea |2001-10-15| USA      |New York | 11    |js_zouambia@esi.dz|05134891711|بروثن|كمال|المدية|
    And I click Submit
    Then The Intern should not be added with success