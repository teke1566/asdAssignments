package org.example.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class PensionPlan {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    private double monthlyContribution;

    public PensionPlan(LocalDate enrollmentDate, double monthlyContribution) {
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }


    @JsonProperty("enrollmentDate")
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    @JsonProperty("monthlyContribution")
    public double getMonthlyContribution() {
        return monthlyContribution;
    }
}
