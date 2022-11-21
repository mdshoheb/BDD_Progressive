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
    When homepage steps done with <"11368">
    Then about you page steps done

  @data-driven
  Scenario Outline: Data Driven approach for BDD
    When homepage steps done with <zip>
    Then about you page steps done

    Examples: 
      | zip     |
      | '11368' |
      | '11373' |
      | '11369' |
