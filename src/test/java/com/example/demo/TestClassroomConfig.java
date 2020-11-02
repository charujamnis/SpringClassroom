package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;

public class TestClassroomConfig {
    ClassroomConfig classroomConfig;
    @Autowired
    @Qualifier("instructorsBean")
    Instructors instructors;

    @Autowired
    @Qualifier("studentsBean")
    Students students;

    @Autowired
    @Qualifier("studentsPreviousBean")
    Students previousStudents;

    @Before
    public void setUp(){
        classroomConfig=new ClassroomConfig();
    }

    @Test
    public void testCurrentCohort(){
        classroomConfig.currentCohort();
        Assert.assertEquals("Brian",classroomConfig.getInstructorList().get(1).getName());
        Assert.assertEquals("Charu",classroomConfig.getStudentList().get(0).getName());
        Assert.assertFalse(classroomConfig.getStudentList().contains(404L));
    }

    @Test
    public void testPreviousCohort(){
        classroomConfig.previousCohort();
        System.out.println("Name: "+classroomConfig.getInstructorList().get(0).getName());
        Assert.assertEquals("Zan",classroomConfig.getInstructorList().get(0).getName());
        Assert.assertEquals("Vara",classroomConfig.getStudentPreviousList().get(1).getName());
        Assert.assertFalse(classroomConfig.getStudentPreviousList().contains(401L));
    }
}
