Feature: Car Loan Calculation

  @regression @functional
  Scenario: Calculation of car loan
    Given the user navigates to Car Loan section
    When user enters the Car Loan Amount
    And user enters the Interest Rate
    And user enters the Loan Tenure
    Then display interest and principal amount on console
