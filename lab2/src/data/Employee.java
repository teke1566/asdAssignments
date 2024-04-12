package data;

import java.time.LocalDate;
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public String toJSON() {
        StringBuilder json = new StringBuilder("{");
        json.append("\"employeeId\": ").append(employeeId).append(",");
        json.append("\"firstName\": \"").append(firstName).append("\",");
        json.append("\"lastName\": \"").append(lastName).append("\",");
        json.append("\"employmentDate\": \"").append(employmentDate).append("\",");
        json.append("\"yearlySalary\": ").append(yearlySalary);
        if (pensionPlan != null) {
            json.append(", \"pensionPlan\": {");
            json.append("\"enrollmentDate\": \"").append(pensionPlan.getEnrollmentDate()).append("\",");
            json.append("\"monthlyContribution\": ").append(pensionPlan.getMonthlyContribution());
            json.append("}");
        }
        json.append("}");
        return json.toString();
    }
}