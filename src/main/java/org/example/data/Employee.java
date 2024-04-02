package org.example.data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

    public Employee(Long employeeId, String firstName, String lastName, LocalDate employmentDate, double yearlySalary, LocalDate enrollmentDate, double monthlyContribution) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = new PensionPlan(enrollmentDate, monthlyContribution);
    }

    public Employee(Long employeeId, String firstName, String lastName, LocalDate employmentDate, double yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }

    // Getters and setters

    @JsonProperty("employeeId")
    public Long getEmployeeId() {
        return employeeId;
    }

    // Other getters and setters

    @JsonProperty("employmentDate")
    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    @JsonProperty("yearlySalary")
    public double getYearlySalary() {
        return yearlySalary;
    }

    @JsonProperty("pensionPlan")
    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }
}
