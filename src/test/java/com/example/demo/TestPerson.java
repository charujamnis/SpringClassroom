package com.example.demo;

import org.junit.Assert;
import org.junit.Test;

public class TestPerson {

    Person person;

    //Create a testGetName method which ensures that a Person object's
   // name variable using getName() method.
    @Test
    public void testGetName(){
        person=new Person(1L,"Lolu");
        String actual="Lolu";
        String expected=person.getName();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testGetId(){
        person=new Person(2L,"Emad");
        Long actual=2L;
        Long expected=person.getId();
        Assert.assertEquals(actual,expected);
    }

    //Create a testSetName method which ensures that a Person object's
    // name variable is being set by invoking the .setName method.
    @Test
    public void testSetName(){
        person=new Person();
        String actual="Cedric";
        person.setName(actual);
        String expected=person.getName();
        Assert.assertEquals(actual,expected);
    }
}
