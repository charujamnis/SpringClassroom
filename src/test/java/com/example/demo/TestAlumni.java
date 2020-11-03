package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAlumni {

    @Autowired
    @Qualifier("alumni")
    Alumni alumni;
//lecture
    @Test
    public void testExecuteBootCamp(){
        Student albert = (Student) alumni.getpCohort().getStudents().getPersonList().get(0);

        Instructor brian= (Instructor) alumni.getpCohort().getInstructors().getPersonList().get(1);

        int numberOfInstructors=alumni.getpCohort().getInstructors().size();
        int numberOfStudents=alumni.getpCohort().getStudents().size();
        double numberOfHoursToTeachEachStudent = 1200;
        double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents;
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;
        Assert.assertEquals(4800,numberOfHoursToTeach,0);
        Assert.assertEquals("Albert",albert.getName());
        Assert.assertEquals(222L,albert.getId());
        Assert.assertEquals(1200,brian.getNumberOfHoursPerLearner(),0);
        Assert.assertEquals(2400,albert.getTotalStudyTime(),0);
        Assert.assertEquals(2400,numberOfHoursPerInstructor,0);
        Assert.assertEquals("Brian",brian.getName());
        Assert.assertEquals(302L,brian.getId());
    }
}
