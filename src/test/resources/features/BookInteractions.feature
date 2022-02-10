Feature: Interacting with projects management system
  Creating projects, Creating tasks, Assigning employees to project/task

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
