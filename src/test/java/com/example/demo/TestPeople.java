package com.example.demo;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestPeople {
    People people;

    @Before
    public void setUp(){
        List<Person> personList=new ArrayList<>();
        Student student=new Student(1L,"Lolu");
        Student student1=new Student(1L,"Apoorva");
        Instructor instructor=new Instructor(2L,"Brian");
        Instructor instructor1=new Instructor(2L,"Zan");
        personList.add(student);
        personList.add(student1);
        personList.add(instructor);
        personList.add(instructor1);

    }
}
