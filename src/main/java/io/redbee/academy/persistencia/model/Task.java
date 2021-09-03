package io.redbee.academy.persistencia.model;

import java.time.LocalDate;

public class Task {

    private String description;
    private LocalDate deadline;
    private Integer employeeId;

    public Task(String description, LocalDate deadline, Integer employeeId) {
        this.description = description;
        this.deadline = deadline;
        this.employeeId = employeeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

}
