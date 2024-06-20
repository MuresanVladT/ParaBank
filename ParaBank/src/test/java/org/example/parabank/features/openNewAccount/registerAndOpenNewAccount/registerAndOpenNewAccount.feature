Feature: ParaBank register and open a new account

  Scenario Outline:
    Given user is on the ParaBank registration page
    When user enters valid credentials for register "<address>" "<city>" "<state>" "<zipCode>" "<phone>" "<ssn>" "<password>"
    Then user is registered

    Given user is on the ParaBank openNewAccount page
    When the user selects an account type "<accountType>"
    And selects the account from where to transfer money and open new account
    Then user creates a new account

    Examples:
      | address  | city   | state  | zipCode | phone      | ssn    | password      | accountType|
      | Str. xyz | Cancun | Mexico | 123321  | 0712345678 | 112233 | validPassword | SAVINGS    |


