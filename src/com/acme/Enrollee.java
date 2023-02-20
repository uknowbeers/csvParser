package com.acme;

import java.util.Objects;

/**
 * Object representing Enrollee data
 */
class Enrollee implements Comparable{
    String userId;
    String firstName;
    String lastName;
    String version;
    String insuranceCompany;

    // Constructor
    public Enrollee(String userId, String firstName, String lastName, String version, String insuranceCompany) {
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollee enrollee = (Enrollee) o;
        return Objects.equals(userId, enrollee.userId) && Objects.equals(firstName, enrollee.firstName) && Objects.equals(lastName, enrollee.lastName) && Objects.equals(version, enrollee.version) && Objects.equals(insuranceCompany, enrollee.insuranceCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, version, insuranceCompany);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Enrollee) {
            int lastCmp = lastName.compareTo(((Enrollee)o).getLastName());
            return (lastCmp != 0 ? lastCmp : firstName.compareTo(((Enrollee)o).getFirstName()));
        }
        return -1;
    }
}
