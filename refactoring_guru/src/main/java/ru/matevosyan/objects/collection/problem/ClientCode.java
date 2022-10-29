package ru.matevosyan.objects.collection.problem;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ClientCode {

    void setCourseToPerson() {
        Person kent = new Person();
        Set<Course> s = new HashSet<>();
        s.add(new Course("Smalltalk Programming", false));
        s.add(new Course("Appreciating Single Malts", true));
        kent.setCourses(s);

        Course refact = new Course("Refactoring", true);
        kent.getCourses().add(refact);
        kent.getCourses().add(new Course("Brutal Sarcasm", false));
        kent.getCourses().remove(refact);

        Iterator iter = kent.getCourses().iterator();
        int count = 0;
        while (iter.hasNext()) {
            Course each = (Course) iter.next();
            if (each.isAdvanced()) {
                count++;
            }
        }
        System.out.print("Advanced courses: " + count);
    }
}
