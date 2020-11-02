package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ClassroomConfig {
    List<Instructor> instructorList;
    List<Student> studentList;
    List<Student> studentPreviousList;

    public ClassroomConfig(){}

    @Bean(name="instructorsBean")
    public Instructors instructors(){
        studentList=new ArrayList<>();
        instructorList=new ArrayList<>();
        instructorList.add(new Instructor(301L,"Zan"));
        instructorList.add(new Instructor(302L,"Brian"));
        return new Instructors(instructorList);
    }

    @Bean(name="studentsBean")
    public Students students(){
        studentList.add(new Student(401L,"Charu"));
        studentList.add(new Student(402L,"Sam"));
        studentList.add(new Student(403L,"Tisha"));
        return new Students(studentList);
    }

    @Bean(name="studentsPreviousBean")
    public Students previousStudents(){
        studentPreviousList=new ArrayList<>();
        studentPreviousList.add(new Student(404L,"Niesha"));
        studentPreviousList.add(new Student(405L,"Vara"));
        studentPreviousList.add(new Student(406L,"Craig"));
        return new Students(studentPreviousList);
    }

    @Bean
    @DependsOn(value={"instructorsBean","studentsBean"})
    public Classroom currentCohort(){
        return new Classroom(instructors(),students());
    }

    @Bean
    @DependsOn(value={"instructorsBean","studentsPreviousBean"})
    public Classroom previousCohort(){
        return new Classroom(instructors(),previousStudents());
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentPreviousList() {
        return studentPreviousList;
    }

    public void setStudentPreviousList(List<Student> studentPreviousList) {
        this.studentPreviousList = studentPreviousList;
    }
}
