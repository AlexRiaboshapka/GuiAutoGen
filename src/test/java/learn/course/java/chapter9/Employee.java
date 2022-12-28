package learn.course.java.chapter9;

import logger.CustomLogger;

public class Employee extends Person {
    private String employeeId;
    private String title;

    public Employee() {
        super("test");
        CustomLogger.logger.info("Employee constructor");
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
