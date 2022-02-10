package uni.plovdiv.bg.model;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private String description;
    private List<Task> subTasks;
    private State state;
    private Employee assignee;

    public Task(String description, State state, Employee assignee) {
        subTasks = new ArrayList<>();
        setDescription(description);
        setState(state);
        setAssignee(assignee);
    }

    public void changeState(State state, String description) {
        setState(state);
        setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("description can not be null or empty");
        }
        this.description = description;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public State getState() {
        return state;
    }

    private void setState(State state) {
        if (state == null) {
            throw new IllegalArgumentException("state can not be null");
        }
        if (this.state == State.FINISHED) {
            throw new RuntimeException("State can not be changed after being set to finished");
        }
        this.state = state;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        if (assignee == null) {
            throw new IllegalArgumentException("assignee can not be null or empty");
        }
        this.assignee = assignee;
    }

    public void setAssigneeToEmpty() {
        assignee = null;
    }

    public void addSubTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task can not be null");
        }
        subTasks.add(task);
    }

    public void start() {
        if (assignee == null) {
            throw new RuntimeException("Task can not be started without assignee");
        }
        state = State.IN_PROGRESS;
    }
}
