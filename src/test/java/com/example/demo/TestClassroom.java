package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClassroom {
    Classroom classroom;
    Instructor brian;Instructor zan;
    Student lolu; Student apoorva;
    List<Student> studentList=new ArrayList<>();
    List<Instructor> instructorList=new ArrayList<>();
    Students students;
    Instructors instructors;

    @Before
    public void setUp(){
        lolu=new Student(1L,"Lolu");
        apoorva=new Student(1L,"Apoorva");
        brian=new Instructor(2L,"Brian");
        zan=new Instructor(2L,"Zan");
        studentList.add(lolu);
        studentList.add(apoorva);
        instructorList.add(brian);
        instructorList.add(zan);

        students=new Students(studentList);
        instructors=new Instructors(instructorList);
        classroom=new Classroom(instructors,students);
    }

    @Test
    public void testHostLecture(){
        brian.lecture(studentList,10.00);
        double actual=5.00;
        double expected= lolu.getTotalStudyTime();
        Assert.assertEquals(actual,expected,0);
    }
}
