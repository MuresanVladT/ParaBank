Feature: ParaBank OpenNewAccount

  Scenario Outline: Successful open a new account
    Given user is on the ParaBank openNewAccount page
    When the user selects an account type "<accountType>"
    And selects the account from where to transfer money and open new account "<transferAccount>"
    Then user creates a new account, the page title should be "<expectedPageTitle>"
    Examples:
      | accountType | transferAccount |
      | CHECKING    | 13899           |
      | SAVINGS     | 13899           |