package com.practice.objects.collection.solution;

public class ClientCode {

    void addCoursesToPerson() {
        Person kent = new Person();
        kent.addCourse(new Course("Smalltalk Programming", false));
        kent.addCourse(new Course("Appreciating Single Malts", true));

        Course refact = new Course("Refactoring", true);
        kent.addCourse(refact);
        kent.addCourse(new Course("Brutal Sarcasm", false));
        kent.removeCourse(refact);

        System.out.print("Advanced courses: " + kent.numberOfAdvancedCourses());
    }
}
