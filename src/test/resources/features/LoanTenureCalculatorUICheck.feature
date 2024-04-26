Feature: Loan Tenure Calculator UI check

  @functional
  Scenario: Validate the UI features of Loan Tenure Calculator
    Given user navigates to Loan Tenure Calculator
    When user enters loan amount in the loan amount input box in LTC
    Then loan amount slider should be moved to the same value in LTC
    When user enters EMI amount in the EMI amount input box in LTC
    Then EMI amount slider should be moved to the same value in LTC
    When user enters interest rate in the interest rate input box in LTC
    Then interest rate slider should be moved to the same value in LTC
    When user enters charges in the charges input box in LTC
    Then charges slider should be moved to the same value in LTC
