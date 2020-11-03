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
    Alumni alumni;
//lecture
    @Test
    public void testExecuteBootCamp(){
        Student student1= (Student) alumni.getStudents().getPersonList().get(0);
        Instructor instructor1= (Instructor) alumni.getInstructors().getPersonList().get(1);

        int numberOfInstructors=alumni.getInstructors().size();
        int numberOfStudents=alumni.getStudents().size();
        double numberOfHoursToTeachEachStudent = 1200;
        double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents;
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;
        alumni.executeBootCamp();
        Assert.assertEquals(3600,numberOfHoursToTeach,0);
        Assert.assertEquals("Albert",student1.getName());
        Assert.assertEquals(222L,student1.getId());
       // Assert.assertEquals(1200,numberOfHoursPerInstructor,0);
        Assert.assertEquals(1800,numberOfHoursPerInstructor,0);

        Assert.assertEquals("Brian",instructor1.getName());
        Assert.assertEquals(302L,instructor1.getId());
    }

}
