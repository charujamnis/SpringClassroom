package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStudent {
    Student student;

    @Before
    public void setUp(){
        student=new Student(1L,"Reena");
    }
    @Test
    public void testImplementation(){
        Assert.assertTrue(student instanceof Learner);
    }

    @Test
    public void testInheritance(){
        Assert.assertTrue(student instanceof Person);
    }

    @Test
    public void testLearn(){
        student.learn(4.00);
        double actual=4.0;
        double expected=student.getTotalStudyTime();
        Assert.assertEquals(actual,expected,0);
    }
}
