package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestInstructorConfig {

    @Autowired
    @Qualifier("delTechTuesdayInstructors")
    Instructors tuesdayInstructors;

    @Autowired
    @Qualifier("delTechThursdayInstructors")
    Instructors thursdayInstructors;

    @Autowired
    @Qualifier("allDelTechInstructors")
    Instructors allInstructors;

    @Test
    public void testTuesdayInstructors(){
        List<Instructor> list=new ArrayList<>();
        list=tuesdayInstructors.getPersonList();
        Assert.assertEquals("Brian",tuesdayInstructors.findById(10L).getName());
        Assert.assertEquals(11L,list.get(1).getId());
        for(int i=0;i<list.size();i++) {
            Assert.assertFalse(list.get(i).getId()==12L); //12L in not tuesdayInstructors list.
        }

    }

    @Test
    public void testThursdayInstructors(){
        List<Instructor> list=new ArrayList<>();
        list=thursdayInstructors.getPersonList();
        Assert.assertEquals("Zan",thursdayInstructors.findById(12L).getName());
        Assert.assertEquals(13L,list.get(1).getId());
        for(int i=0;i<list.size();i++) {
            Assert.assertFalse(list.get(i).getId()==10L); //10L in not thursdayInstructors list.
        }
    }

    @Test
    public void testAllInstructors(){
        List<Instructor> list=new ArrayList<>();
        list=allInstructors.getPersonList();
        int size=allInstructors.getPersonList().size();
        Assert.assertEquals("Brian",allInstructors.findById(10L).getName());
        Assert.assertEquals("Zan",allInstructors.findById(12L).getName());
        Assert.assertEquals("Kaleb",allInstructors.findById(11L).getName());
        Assert.assertEquals("Julia",allInstructors.findById(13L).getName());
        Assert.assertEquals(10L,list.get(0).getId());
        Assert.assertEquals(12L,list.get(2).getId());

    }
}
