package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestInstructors {
    List<Instructor> instructorList=new ArrayList<>();
    Instructors instructors;
    Instructor zan;
    Instructor kaleb;
    Instructor jenny;

    @Before
    public void setUp(){
        zan=new Instructor(1L,"Zan");
        kaleb =new Instructor(2L,"Kaleb");
        jenny=new Instructor(3L,"Jenny");
        instructorList.add(zan);
        instructorList.add(kaleb);
        instructorList.add(jenny);
        instructors=new Instructors(instructorList);
    }
    @Test
    public void testInstructorListSize(){
        int actual=3;
        int expected =instructors.personList.size();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testAddInstructor(){
        Instructor brian=new Instructor(4L,"Brian");
        instructors.add(brian);
        String actual="Brian";
        String expected=instructors.findById(4L).getName();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testRemoveInstructor(){
        instructors.remove(jenny);
        Assert.assertFalse(instructorList.contains(jenny));
    }

    @Test
    public void testFindById(){
        Instructor sia=new Instructor(5L,"Sia");
        Long actual=5L;
        instructors.add(sia);
        Long expected=instructors.findById(5L).getId();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testAddAll(){
        List<Instructor> newList=new ArrayList<>();
        Instructor sahil=new Instructor(6L,"Sahil");
        Instructor rohan=new Instructor(7L,"Rohan");
        newList.add(sahil);
        newList.add(rohan);
        instructors.addAll(newList);
        String actual="Rohan";
        String expected=instructors.findById(7L).getName();
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void testClear(){
        instructors.personList.clear();
        Assert.assertEquals(0,instructors.personList.size());
    }
}

