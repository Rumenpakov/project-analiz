package uni.plovdiv.bg.model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String description;
    private List<Project> subProjects;
    private List<Employee> teamMembers;
    private List<Task> tasks;

    public Project(String description) {
        subProjects = new ArrayList<>();
        teamMembers = new ArrayList<>();
        tasks = new ArrayList<>();
        this.description = description;
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new RuntimeException("Task can not be null");
        }
        tasks.add(task);
    }

    public void addSubProject(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Project can not be null");
        }
        subProjects.add(project);
    }

    public void addTeamMember(Employee teamMember) {
        if (teamMember == null) {
            throw new IllegalArgumentException("Team member can not be null");
        }

        this.teamMembers.add(teamMember);
    }

    public List<Project> getSubProjects() {
        return subProjects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getDescription() {
        return description;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }
}
