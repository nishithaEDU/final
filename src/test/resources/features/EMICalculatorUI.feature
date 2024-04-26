Feature: EMI Calculator UI check

  @functional
  Scenario: Validate the UI features of EMI Calculator
    Given user navigates to EMI Calculator
    When user enters loan amount in the loan amount input box
    Then loan amount slider should be moved to the same value
    When user enters interest rate in the interest rate input box
    Then interest rate slider should be moved to the same value
    When user enters loan tenure in the loan tenure input box
    Then loan tenure slider should be moved to the same value
    When user clicks on month tenure
    Then the slider should be moved to the same value
    When user enters charges in the charges input box
    Then charges slider should be moved to the same value
