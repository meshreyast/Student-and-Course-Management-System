package com.airtribe.learntrack.entity;

public class Trainer extends Person{

    @Override
    public String getDisplayName() {
        return "The Trainer's name is: " + getFirstName() + " " + getLastName();
    }
}
