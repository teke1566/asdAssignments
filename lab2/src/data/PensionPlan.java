package data;

import java.time.LocalDate;

class PensionPlan {
    private LocalDate enrollmentDate;
    private double monthlyContribution;

    public PensionPlan(LocalDate enrollmentDate, double monthlyContribution) {
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public double getMonthlyContribution() {
        return monthlyContribution;
    }
}