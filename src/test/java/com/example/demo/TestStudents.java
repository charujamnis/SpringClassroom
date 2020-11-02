package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestStudents {
    List<Student> studentList=new ArrayList<>();
    Students students;
    Student jessica;
    Student lolu;
    Student apoorva;

    @Before
    public void setUp(){
        jessica=new Student(1L,"Jessica");
        lolu =new Student(2L,"Lolu");
        apoorva=new Student(3L,"Apoorva");
        studentList.add(jessica);
        studentList.add(lolu);
        studentList.add(apoorva);
        students=new Students(studentList);
    }
    @Test
    public void testStudentsListSize(){
        int actual=3;
        int expected =students.personList.size();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testAddInstructor(){
        Student vara=new Student(4L,"Vara");
        students.add(vara);
        String actual="Vara";
        String expected=students.findById(4L).getName();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testRemoveInstructor(){
        students.remove(jessica);
        Assert.assertFalse(studentList.contains(jessica));
    }

    @Test
    public void testFindById(){
        Student elle=new Student(5L,"Elle");
        Long actual=5L;
        students.add(elle);
        Long expected=students.findById(5L).getId();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testAddAll(){
        List<Student > newList=new ArrayList<>();
        Student ramona=new Student(6L,"Ramona");
        Student era=new Student(7L,"Era");
        newList.add(ramona);
        newList.add(era);
        Students addStudents=new Students(newList);
        addStudents.addAll();
        String actual="Era";
        String expected=addStudents.findById(7L).getName();
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void testClear(){
        students.personList.clear();
        Assert.assertEquals(0,students.personList.size());
    }
}

