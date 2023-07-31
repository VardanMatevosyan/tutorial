package com.practice.classes.extraction.solution;

class TelephoneNumber {
    private String areaCode;
    private String number;

    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String arg) {
        areaCode = arg;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String arg) {
        number = arg;
    }
    public String getTelephoneNumber() {
        return ("(" + areaCode + ") " + number);
    }
}