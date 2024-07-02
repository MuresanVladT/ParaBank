Feature: ParaBank request a loan

  Scenario Outline: Request a loan successful

    Given user is on the ParaBank registration page
    When user enters valid credentials for register "<address>" "<city>" "<state>" "<zipCode>" "<phone>" "<ssn>" "<password>"
    Then user is registered

    Given user is on the RequestLoan page
    When user enters desired loan amount, down payment and fromAccount "<loanAmount>", "<downPayment>"
    And click Apply Now button
    Then the loan request is processed, Status:Approved

    Examples:
      | address  | city   | state  | zipCode | phone      | ssn    | password      | loanAmount | downPayment |
      | Str. xyz | Cancun | Mexico | 123321  | 0712345678 | 112233 | validPassword | 1000       | 100         |