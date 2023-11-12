Feature: Calculate net price
  Scenario: Gross price is a positive integer
    Given I have a gross price of 100.0
    When I calculate the net price
    Then I should get a net price of 125.00

    Given I have a gross price of 50.0
    When I calculate the net price
    Then I should get a net price of 62.50

    Given I have a gross price of 999.0
    When I calculate the net price
    Then I should get a net price of 1248.75


  Scenario: Gross price is a positive floating point number
    Given I have a gross price of 100.5
    When I calculate the net price
    Then I should get a net price of 125.63

    Given I have a gross price of 50.7
    When I calculate the net price
    Then I should get a net price of 63.38

    Given I have a gross price of 999.9
    When I calculate the net price
    Then I should get a net price of 1249.88

  Scenario: Bad input value
    Given I have a gross price of -100.00
    When I calculate the net price
    Then I should get this error message "Gross price must be zero or greater"

    Given I have a gross price of -100.5
    When I calculate the net price
    Then I should get this error message "Gross price must be zero or greater"

  Scenario: Gross price is zero
    Given I have a gross price of 0.0
    When I calculate the net price
    Then I should get a net price of 0.00

    Given I have a gross price of 0.0
    When I calculate the net price
    Then I should get a net price of 0.00
