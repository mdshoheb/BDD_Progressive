@auto
Feature: Auto Quote Validation

  Scenario: Auto quote test
    Given user navigate to homepage
    When user select auto
    And user input zipcode
    And click start quote
    Then user will be in about you page
    When user input firstName
    And user input middle initial
    And user input lastName
    And user input dob
    And user input mailing address
    And user input apartment number
    And user input city name
    Then user should be able to click okay button

  @newSteps
  Scenario: auto quote page steps
    When homepage steps done
    Then about you page steps done
