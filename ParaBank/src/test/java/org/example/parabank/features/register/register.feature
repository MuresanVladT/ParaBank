Feature: ParaBank Register

  Scenario Outline: Successful register with valid credentials
    Given user is on the ParaBank's registering page
    When user enters valid credentials for register "<address>" "<city>" "<state>" "<zipCode>" "<phone>" "<ssn>" "<password>"
    Then user is registered

    Examples:
      | address  | city   | state | zipCode | phone      | ssn    | password      |
      | Str. xyz | Cancun | Mexic | 123321  | 0712345678 | 112233 | validPassword |