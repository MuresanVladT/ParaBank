Feature: ParaBank Register, open an new account and perform a transfer

  Scenario Outline: Successful register and opening a new bank account, then perform a transfer
    Given user is on the ParaBank registration page
    When user enters valid credentials for register "<address>" "<city>" "<state>" "<zipCode>" "<phone>" "<ssn>" "<password>"
    Then user is registered

    Given user is on the ParaBank openNewAccount page
    When the user selects an account type "<accountType>"
    And selects the account from where to transfer money and open new account
    Then user creates a new account

    Given user is on the ParaBank transfer page
    When user selects the amount of the transfer, from account and to account "<amount>"
    And click the transfer button
    Then user receive the confirmation message


    Examples:
      | address  | city   | state  | zipCode | phone      | ssn    | password      | accountType|amount|
      | Str. xyz | Cancun | Mexico | 123321  | 0712345678 | 112233 | validPassword | CHECKING    |10000 |