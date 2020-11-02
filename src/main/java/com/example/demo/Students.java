package com.example.demo;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Students<Student> extends People{
    List<Student> studentsList;

    public Students(List studentsList) {
        //this.studentsList=studentsList;
        super(studentsList);
    }

    @Override
    public Iterator iterator() {
        return this.studentsList.listIterator();
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
}
