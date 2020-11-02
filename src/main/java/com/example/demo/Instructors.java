package com.example.demo;

import java.util.Iterator;
import java.util.List;
//The class should be a subclass of People of parameterized type Instructor.

public class Instructors<Instructor> extends People {
    List<Instructor> instructorsList;

    public Instructors(List<Instructor> instructorsList){
        super(instructorsList);
    }

    @Override
    public Iterator iterator() {
        return this.instructorsList.listIterator();
    }
}
