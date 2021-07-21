package com.vollberg.availity;

public class Enrollee implements Comparable<Enrollee> {
    
    private String userId;
    private String firstName;
    private String lastName;
    private Integer version;
    private String insuranceCompany;

    public Enrollee(String userId, String firstName, String lastName, Integer version, String insuranceCompany) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
        this.insuranceCompany = insuranceCompany;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public int compareTo(Enrollee enrollee) {
        int last = this.lastName.compareTo(enrollee.lastName);
        return last == 0 ? this.firstName.compareTo(enrollee.firstName) : last;
    }

    public String toString() {
        return userId + ", " + firstName + ", " + lastName + ", " + version + ", " + insuranceCompany + "\n";
    }
}