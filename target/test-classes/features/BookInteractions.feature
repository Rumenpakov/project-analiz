Feature: Interacting with projects management system
  Creating projects, Creating tasks, Assigning employees to project/task

#  Scenario: User tries to borrow book with available copy
#    Given user logged in
#    And there is available copy
#    When user tries to borrow book
#    Then book should be handed to user

  Scenario: User tries to add subproject to project
    Given subproject exists
    And  project exists
    When user tries to add subproject
    Then subproject should be part of main project

  Scenario: User tries to add employee to project
    Given project exists
    And employee exists
    When user tries to add employee to project
    Then employee should be part of project

  Scenario: User tries to add subtask to task
    Given task exists
    And subtask exists
    When user tries to add subtask to task
    Then subtask should be part of task

  Scenario: User tries to add task to project
    Given project exists
    And task exists
    When user tries to add task to project
    Then task should be part of project

  Scenario: User tries to start task without assignee
    Given task exists
    And task has no assignee
    When user tries to start task
    Then task should not start

  Scenario: When state of task is changed, description should be updated
    Given task exists
    When user tries to change state of task
    Then task description should be updated

  Scenario: When state of task is finished, state can not be changed
    Given task exists
    And task state is finished
    When user tries to change state of task
    Then state change should fail

#  Scenario: User tries to borrow book with no available copy
#    Given user logged in
#    And there is no available copy
#    When user tries to borrow book
#    Then borrow request status should be unsuccessful
#
#  Scenario: User tries to borrow a book where a copy is reserved for him
#    Given user logged in
#    And there is a copy locked for the user
#    When user tries to borrow book
#    Then book should be handed to user
#
#  Scenario: User tries to postpone book return date with allowed amount
#    Given user logged in
#    And user has borrowed book
#    When user tries to postpone book
#    Then postponement is successful
#
#  Scenario: Postpone request with more than the maximum days allowed is made
#    Given user logged in
#    And user has borrowed book
#    When user tries to postpone book for more than the days allowed
#    Then postponement declined
#
#  Scenario: read online book request is made
#    Given user logged in
#    When read online book request is made
#    Then book should be added to the users used books
#
#  Scenario: Download e-book request is made for book with download link present
#    Given user logged in
#    And e-book with download link is present
#    When user tries to download book
#    Then book should be added to the users downloaded books
#
#  Scenario: Download e-book request i made for book without download link present
#    Given user logged in
#    And e-book without download link is present
#    When user tries to download book with no download url
#    Then download is unsuccessful