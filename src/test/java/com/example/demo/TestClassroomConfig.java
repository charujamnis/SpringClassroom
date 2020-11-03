package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClassroomConfig {
    @Autowired
    ClassroomConfig classroomConfig;

    @Autowired
    @Qualifier("instructorsBean")
    Instructors instructors;

    @Autowired
    @Qualifier("students")
    Students students;

    @Autowired
    @Qualifier("previousStudents")
    Students previousStudents;

    @Before
    public void setUp(){
        classroomConfig=new ClassroomConfig();
    }

    @Test
    public void testCurrentCohort(){
        classroomConfig.currentCohort();
        Student sam= (Student) students.getPersonList().get(0);
        Student tisha= (Student) students.getPersonList().get(1);
        Student elle= (Student) students.getPersonList().get(2);
        Assert.assertEquals("Brian",classroomConfig.getInstructorList().get(1).getName());
        Assert.assertEquals("Sam",sam.getName());
        Assert.assertEquals("Tisha",tisha.getName());
        Assert.assertEquals(220L,elle.getId());
    }

    @Test
    public void testPreviousCohort(){
        classroomConfig.previousCohort();
        Student albert= (Student) previousStudents.getPersonList().get(0);
        Student corie= (Student) previousStudents.getPersonList().get(1);
        Student robert= (Student) previousStudents.getPersonList().get(2);
        Assert.assertEquals("Albert",albert.getName());
        Assert.assertEquals("Corie",corie.getName());
        Assert.assertEquals(224L,robert.getId());
    }
}