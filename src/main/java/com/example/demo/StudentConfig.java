package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    List<Student> newStudents;
    List<Student> oldStudents;

    public StudentConfig(){ }

    @Bean(name="students")
    public Students currentStudents(){
        newStudents=new ArrayList<>();
        newStudents.add(new Student(218L,"Sam"));
        newStudents.add(new Student(219L,"Tisha"));
        newStudents.add(new Student(220L,"Elle"));
        newStudents.add(new Student(221L,"Alexa"));
        return new Students(newStudents);
    }

    @Bean(name="previousStudents")
    public Students previousStudents(){

        oldStudents=new ArrayList<>();
        oldStudents.add(new Student(222L,"Albert"));
        oldStudents.add(new Student(223L,"Corie"));
        oldStudents.add(new Student(224L,"Robert"));
        oldStudents.add(new Student(225L,"Niesha"));
        return new Students(oldStudents);
    }

    public List<Student> getNewStudents() {
        return newStudents;
    }

    public void setNewStudents(List<Student> newStudents) {
        this.newStudents = newStudents;
    }

    public List<Student> getOldStudents() {
        return oldStudents;
    }

    public void setOldStudents(List<Student> oldStudents) {
        this.oldStudents = oldStudents;
    }
}
