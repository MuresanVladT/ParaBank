Feature: ParaBank Login

  Scenario Outline: Successful Login with valid credentials
    Given user is on the ParaBank login page
    When  user enters valid credentials "<username>" "<password>"
    Then  user is logged in

    Examples:
      | username    | password    |
      | vladMuresan | vladMuresan |