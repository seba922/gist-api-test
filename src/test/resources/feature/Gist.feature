@gist
Feature: Gist create, read, delete

  Scenario Outline: User add comment and then read it
    When IO add comment "<Comment>"
    Then IO get added comment
    And Status code is 200
    And Comment id is correct
    And Response has comment "<Comment>"
    Examples:
      | Comment     |
      | Hello world |

  Scenario: User add comment with incorrect body
    When IO add comment with null value in body
    Then Status code is 422

  Scenario: User get list of all comments
    When IO gets all comments
    Then Status code is 200

  Scenario: User add comment and get list of all comments
    When IO add comment "Hello world"
    Then Status code is 201
    When IO gets all comments
    Then List of all comments is bigger than 0

  Scenario: User remove added comment
    When IO add comment "Hello world"
    And IO remove added comment
    Then Status code is 204
