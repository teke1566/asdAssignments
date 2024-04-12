package edu.miu.cs489.quiz;

public class Contact {
    private String firstName;
    private String lastName;
    private String companyField;
    private String jobTitle;


    public Contact(String firstName, String lastName, String companyField, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyField = companyField;
        this.jobTitle = jobTitle;

    }

    public Contact() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyField() {
        return companyField;
    }

    public void setCompanyField(String companyField) {
        this.companyField = companyField;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}


