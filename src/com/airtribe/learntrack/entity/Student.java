package com.airtribe.learntrack.entity;

public class Student extends Person{

    private String batch;
    private boolean active;

    public Student () {

    }

    public Student(int id, String firstName, String lastName, String batch, boolean active) {
        super(id, firstName, lastName, null);
        this.batch = batch;
        this.active = active;
    }


    public Student(int id, String firstName, String lastName, String email, String batch, boolean active) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    @Override
    public String getDisplayName() {
        return "The Student's name is: " + getFirstName() + " " + getLastName() + " of batch " + getBatch();
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student{"
                + "id= '" +  super.getId() + '\''
                + ", first name= '" + super.getFirstName() + '\''
                + ", last name= '" + super.getLastName() + '\''
                + ", email= '" + super.getEmail() + '\''
                + ", batch='" + batch + '\''
                + ", active=" + active +
                '}';
    }
}
