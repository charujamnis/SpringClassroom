package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudentConfig {
    @Autowired
    StudentConfig config;

    @Autowired
    @Qualifier("students")
    Students cStudents;

    @Autowired
    @Qualifier("previousStudents")
    Students pStudents;

    @Test
    public void testCurrentStudents(){
        Assert.assertEquals("Elle",cStudents.findById(220L).getName());
        Assert.assertEquals("Alexa",cStudents.findById(221L).getName());
    }

    @Test
    public void testPreviousStudents(){
        Assert.assertEquals("Albert",pStudents.findById(222L).getName());
        Assert.assertEquals("Corie",pStudents.findById(223L).getName());
    }
}
