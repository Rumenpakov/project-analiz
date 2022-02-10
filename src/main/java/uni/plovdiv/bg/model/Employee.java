package uni.plovdiv.bg.model;

public class Employee {

    private String name;

    protected Employee(String name) {
        setName(name);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can not be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
