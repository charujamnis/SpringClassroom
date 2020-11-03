package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ClassroomConfig {

    @Autowired
    @Qualifier("students")
    Students newStudents;

    @Autowired
    @Qualifier("previousStudents")
    Students oldStudents;

    List<Instructor> instructorList;

    public ClassroomConfig(){}

    @Bean(name="instructorsBean")
    public Instructors instructors(){
        instructorList=new ArrayList<>();
        instructorList.add(new Instructor(301L,"Zan"));
        instructorList.add(new Instructor(302L,"Brian"));
        return new Instructors(instructorList);
    }

    @Bean(name="currentCohort")
    @DependsOn(value={"instructorsBean","students"})
    public Classroom currentCohort(){
        return new Classroom(instructors(),newStudents);
    }

    @Bean(name="previousCohort")
    @DependsOn(value={"instructorsBean","previousStudents"})
    public Classroom previousCohort(){
        return new Classroom(instructors(),oldStudents);
    }

    public Students getNewStudents() {
        return newStudents;
    }

    public void setNewStudents(Students newStudents) {
        this.newStudents = newStudents;
    }

    public Students getOldStudents() {
        return oldStudents;
    }

    public void setOldStudents(Students oldStudents) {
        this.oldStudents = oldStudents;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }
}