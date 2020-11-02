package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestInstructor {
    Instructor instructor;

    @Before
    public void setUp(){
        instructor=new Instructor(1L,"Zan");
    }

    @Test
    public void testImplementation(){
        Assert.assertTrue(instructor instanceof Teacher);
    }

    @Test
    public void testInheritance(){
        Assert.assertTrue(instructor instanceof Person);
    }

    @Test
    public void testTeach(){
        Student student=new Student(2L,"Jennifer");
        instructor.teach(student,3.00);
        Assert.assertEquals(3,student.getTotalStudyTime(),0);
    }

    @Test
    public void testLecture(){
        List<Student> students =new ArrayList<>();
        students.add(new Student(1L,"Sam"));
        students.add(new Student(2L,"Anita"));
        students.add(new Student(3L,"Meena"));

        instructor.lecture(students,15.00);
        Assert.assertEquals(5,students.get(0).getTotalStudyTime(),0);
    }
}
