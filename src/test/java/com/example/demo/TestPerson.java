package com.example.demo;

import org.junit.Assert;
import org.junit.Test;

public class TestPerson {

    Person person;

    //Create a testGetName method which ensures that a Person object's
   // name variable using getName() method.
    @Test
    public void testGetName(){
        person=new Person(1L,"Seema");
        String actual="Seema";
        String expected=person.getName();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testGetId(){
        person=new Person(2L,"Bina");
        Long actual=2L;
        Long expected=person.getId();
        Assert.assertEquals(actual,expected);
    }
}
