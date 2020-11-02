package com.example.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class TestStudents {
    List<Student> studentList=new ArrayList<>();
    Students students;
    Student stephen;
    Student lolu;
    Student apoorva;

    @Before
    public void setUp(){
        lolu =new Student(1L,"Lolu");
        stephen=new Student(2L,"Stephen");
        apoorva=new Student(3L,"Apoorva");
        studentList.add(lolu);
        studentList.add(stephen);
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
        Student vara=new Student(9L,"Vara");
        students.add(vara);
        String actual="Vara";
        String expected=students.findById(9L).getName();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testFindAll(){
        //check composite personList.
        students.add(new Instructor(4L,"Taylor"));
        students.add(new Instructor(5L,"Hannah"));
        String[] actual= {"Lolu","Stephen","Apoorva","Taylor","Hannah"};
        String[] expected=new String[5];

        for(int i=1;i<=students.getPersonList().size();i++){
            expected[i-1]=students.findById((long) i).getName();
        }
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testRemoveInstructor(){
        students.remove(stephen);
        Assert.assertFalse(studentList.contains(stephen));
    }

    @Test
    public void testFindById(){
        Student elle=new Student(6L,"Elle");
        Long actual=6L;
        students.add(elle);
        Long expected=students.findById(6L).getId();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testAddAll(){
        List<Student > newList=new ArrayList<>();
        Student ramona=new Student(7L,"Ramona");
        Student era=new Student(8L,"Era");
        newList.add(ramona);
        newList.add(era);
        students.addAll(newList);
        String actual="Era";
        String expected=students.findById(8L).getName();
        Assert.assertEquals(actual,expected);
    }
/*
       stephen=new Student(1L,"Stephen");
        lolu =new Student(2L,"Lolu");
        apoorva=new Student(3L,"Apoorva");
 */


    @Test
    public void testClear(){
        students.personList.clear();
        Assert.assertEquals(0,students.personList.size());
    }
}

