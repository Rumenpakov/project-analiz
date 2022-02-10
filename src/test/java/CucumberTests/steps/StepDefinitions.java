package CucumberTests.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.omg.SendingContext.RunTime;
import uni.plovdiv.bg.model.*;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private Project project;
    private Project subProject;
    private Employee employee;
    private Task task;
    private Task subTask;

    @Before
    public void clearData() {
        project = null;
        subProject = null;
        task = null;
        subTask = null;
        employee = new Developer("Rumen");
    }

    @Given("subproject exists")
    public void subProjectExists() {
        subProject = new Project("Parent Project");
    }

    @Given("project exists")
    public void projectExists() {
        project = new Project("Parent Project");
    }

    @When("user tries to add subproject")
    public void userTriesToAddSubproject() {
        project.addSubProject(subProject);
    }

    @Then("subproject should be part of main project")
    public void subProjectShouldBePartOfMainProject() {
        assertEquals(project.getSubProjects().size(), 1);
    }

    @And("employee exists")
    public void employeeExists() {
        assertNotNull(employee);
    }

    @When("user tries to add employee to project")
    public void userTriesToAddEmployeeToProject() {
        project.addTeamMember(employee);
    }

    @Then("employee should be part of project")
    public void employeeShouldBePartOfProject() {
        assertEquals(project.getTeamMembers().get(0), employee);
    }

    @And("task exists")
    public void taskExists() {
        task = new Task("Task description", State.NEW, employee);
    }

    @When("user tries to add task to project")
    public void userTriesToAddTaskToProject() {
        project.addTask(task);
    }

    @Then("task should be part of project")
    public void taskShouldBePartOfProject() {
        assertEquals(project.getTasks().get(0), task);
    }

    @And("task has no assignee")
    public void taskHasNoAssignee() {
        task.setAssigneeToEmpty();
    }

    @When("user tries to start task")
    public void userTriesToStartTask() {
        assertThrows(RuntimeException.class, () -> task.start());
    }

    @Then("task should not start")
    public void taskShouldNotStart() {
        assertNotEquals(task.getState(), State.IN_PROGRESS);
    }

    @When("user tries to change state of task")
    public void userTriesToChangeStateOfTask() {
        try {
            task.changeState(State.IN_PROGRESS, "Description update");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("task description should be updated")
    public void taskDescriptionShouldBeUpdated() {
        assertEquals(task.getDescription(), "Description update");
    }

    @And("task state is finished")
    public void taskStateIsFinished() {
        task.changeState(State.FINISHED, "Task finished");
    }

    @Then("state change should fail")
    public void stateChangeShouldFail() {
        assertEquals(task.getState(), State.FINISHED);
    }

    @And("subtask exists")
    public void subtaskExists() {
        subTask = new Task("subTask", State.NEW, employee);
    }

    @When("user tries to add subtask to task")
    public void userTriesToAddSubtaskToTask() {
        task.addSubTask(subTask);
    }

    @Then("subtask should be part of task")
    public void subtaskShouldBePartOfTask() {
        assertEquals(task.getSubTasks().get(0), subTask);
    }
}
