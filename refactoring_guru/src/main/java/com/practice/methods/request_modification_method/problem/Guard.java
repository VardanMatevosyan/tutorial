package com.practice.methods.request_modification_method.problem;

/**
 * Problem.
 * We have two method that do 2 things:
 * get the result (this is request method) and
 * do some modification or sends some data (this is modification method)
 * and this method is hard to read and even more in the future if this method will grow
 * it can take more time to read and understand the functionality behind that.
 * ------------------------------------------------------------------------------------------
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
        String found = findCriminalAndAlert(people);
        someLaterCode(found);
    }
    public String findCriminalAndAlert(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals("Don")) {
                sendAlert();
                return "Don";
            }
            if (people[i].equals("John")) {
                sendAlert();
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
