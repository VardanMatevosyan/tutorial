package ru.matevosyan.objects.collection.problem;

import java.util.Set;

/**
 * Problem
 * The person has courses and getter for the set of courses but this collection can be modified by other classes.
 * In this case client code can't incidentally modify the values.
 * ---------------------------------------------------------------------------------------------------------------
 * Solution
 * We should return an unmodifiable collection in getter method to avoid collection modification from other classes
 * and to allow other classes just to add or remove the object.
 * The client code shouldn't know the structure of the collection.
 * This solution encapsulates the collection of Courses and no one can modify the values, just add or remove them.
 * Also, the owner has control on adding and removing the values.
 * So we encapsulate the collection ultimately reduces the coupling between the owner of the collection
 * and client code that uses the collection.
 * ---------------------------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course.
 */
class Person {
    private Set<Course> courses;

    public Set<Course> getCourses() {
        return courses;
    }
    public void setCourses(Set<Course> arg) {
        courses = arg;
    }
}
