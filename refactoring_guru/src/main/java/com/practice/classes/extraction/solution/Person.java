package com.practice.classes.extraction.solution;

class Person {
    private String name;
    private TelephoneNumber officeTelephone = new TelephoneNumber();

    public String getName() {
        return name;
    }
    public TelephoneNumber getOfficeTelephone() {
        return officeTelephone;
    }
    public String getTelephoneNumber() {
        return officeTelephone.getTelephoneNumber();
    }
}

