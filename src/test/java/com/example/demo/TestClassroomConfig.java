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
        Assert.assertEquals("Zan",classroomConfig.getInstructorList().get(0).getName());
        Assert.assertEquals("Vara",classroomConfig.getStudentPreviousList().get(1).getName());
        Assert.assertFalse(classroomConfig.getStudentPreviousList().contains(401L)); //401L is in currentCohort().
    }
}
