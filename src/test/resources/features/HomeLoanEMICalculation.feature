Feature: Home Loan EMI Calculation

  @regression @functional
  Scenario: Calculation of Home Loan EMI
    Given the user navigates to Home Loan EMI Calculator
    When the user fills the relevant details
    Then extract the data from year on year table to excel
