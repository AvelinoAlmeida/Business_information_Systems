Feature: Add working Period
  Scenario Outline: Define valid Working Periods for a calendar
    Given <h> hours a calendar
    And <n> Employee needed to work
    When I allocate an <employee> to work from <i> to <f>
    Then the result is "result"
    Examples:
      | h | n | employee | i | f | result |
      | 2 | 1 | "Ana"    | 1 | 2 | true   |
      | 2 | 2 | "Jose"   | 3| 4 | false  |