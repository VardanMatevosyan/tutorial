package ru.matevosyan.classes.extraction.problem;

/**
 * Here we have fields that relates to person's telephone information.
 * Also, the problem of this case can be bad database structure.
 * In this case need to check if the DB refer to (third normal form) 3NF.
 * -----------------------------------------------------------------------
 * Solution is to move telephone information to separate class.
 * The Code example is from refactoring guru course.
 */
class Person {
    private String name;
    private String officeAreaCode;
    private String officeNumber;

    public String getName() {
        return name;
    }
    public String getTelephoneNumber() {
        return ("(" + officeAreaCode + ") " + officeNumber);
    }
    public String getOfficeAreaCode() {
        return officeAreaCode;
    }
    public void setOfficeAreaCode(String arg) {
        officeAreaCode = arg;
    }
    public String getOfficeNumber() {
        return officeNumber;
    }
    public void setOfficeNumber(String arg) {
        officeNumber = arg;
    }
}
