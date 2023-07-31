package com.practice.objects.collection.solution;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Solution
 * 1. We should return an unmodifiable collection in getter method to avoid collection modification from other classes
 * and to allow other classes just to add or remove the object.
 * 2. We should create add to collection method and remove from collection method.
 * 3. Assign new empty collection if we don't do it in the constructor.
 * Like addCourse and removeCourse in our Person class.
 * The client code shouldn't know the structure of the collection.
 * This solution encapsulates the collection of Courses and no one can modify the values, just add or remove them.
 * Also, the owner has control on adding and removing the values.
 * So we encapsulate the collection ultimately reduces the coupling between the owner of the collection
 * and client code that uses the collection.
 * ---------------------------------------------------------------------------------------------------------------
 * Code example is from refactoring guru course.
 */
class Person {
    private final Set<Course> courses = new HashSet<>();

    public void initializeCourses(Set<Course> arg) {
        courses.addAll(arg);
    }
    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }
    public void addCourse(Course arg) {
        courses.add(arg);
    }
    public void removeCourse(Course arg) {
        courses.remove(arg);
    }
    public int numberOfAdvancedCourses() {
        Iterator<Course> iter = getCourses().iterator();
        int count = 0;
        while (iter.hasNext()) {
            Course each = iter.next();
            if (each.isAdvanced()) {
                count++;
            }
        }
        return count;
    }
    public int numberOfCourses() {
        return courses.size();
    }
}
