Feature: Loan Amount Calculator UI check

  @functional
  Scenario: Validate the UI features of Loan Amount Calculator
    Given user navigates to Loan Amount Calculator
    When user enters EMI amount in the EMI amount input box
    Then EMI amount slider should be moved to the same value
    When user enters interest rate in the interest rate input box in LAC
    Then interest rate slider should be moved to the same value in LAC
    When user enters loan tenure in the loan tenure input box in LAC
    Then loan tenure slider should be moved to the same value in LAC
    When user clicks on month tenure in LAC
    Then the slider should be moved to the same value in LAC
    When user enters charges in the charges input box in LAC
    Then charges slider should be moved to the same value in LAC
