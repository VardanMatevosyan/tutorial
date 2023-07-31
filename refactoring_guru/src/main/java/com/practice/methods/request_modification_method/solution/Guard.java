package com.practice.methods.request_modification_method.solution;

/**
 * Solution.
 * Separate this method into two methods:
 * request method which will return the data
 * modification method which will do some actions (modify the data for example or send an alert like in this case)
 * After refactoring it will be easy to read, use and understand what is going on.
 * ------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course.
 */
class Guard {
    // ...
    public void checkSecurity(String[] people) {
        doSendAlert(people);
        String found = findCriminal(people);
        someLaterCode(found);
    }

    public void doSendAlert(String[] people) {
        if (findCriminal(people) != "") {
            sendAlert();
        }
    }

    public String findCriminal(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals("Don")) {
                return "Don";
            }
            if (people[i].equals("John")) {
                return "John";
            }
        }
        return "";
    }

    private void someLaterCode(String found) {
        // some operation with alerted people
    }

    private void sendAlert() {
        // sending an alert here
    }
}