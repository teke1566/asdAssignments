package edu.miu.cs489.quiz;

public class PhoneNumber {
    private int phoneNumber;
    private String label;

    public PhoneNumber(int phoneNumber, String label) {
        this.phoneNumber = phoneNumber;
        this.label = label;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
