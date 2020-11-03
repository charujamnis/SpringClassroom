package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InstructorsConfig {
    List<Instructor> tuesdayInstructors;
    List<Instructor> thursdayInstructors;
    List<Instructor> allInstructors;
    Instructors instructorsDelTech;

    @Bean(name="delTechTuesdayInstructors")
    public Instructors delTechTuesdayInstructors(){
        tuesdayInstructors=new ArrayList<>();
        tuesdayInstructors.add(new Instructor(10L,"Brian"));
        tuesdayInstructors.add(new Instructor(11L,"Kaleb"));

        return new Instructors(tuesdayInstructors);
    }

    /*
    *
        instructors.add(new Instructor(100l, "Zan"));
        instructors.add(new Instructor(101l, "Brian"));
        instructors.add(new Instructor(102l, "Kaleb"));
        instructors.add(new Instructor(103l, "Tutor"));*/
    @Bean(name="delTechThursdayInstructors")
    public Instructors delTechThursdayInstructors(){
        thursdayInstructors=new ArrayList<>();
        thursdayInstructors.add(new Instructor(12L,"Zan"));
        thursdayInstructors.add(new Instructor(13L,"Julia"));

        return new Instructors(thursdayInstructors);
    }

    @Primary
    @Bean(name="allDelTechInstructors")
    public Instructors instructors(){
        allInstructors=new ArrayList<>();
        for(Instructor tuesInstructor:tuesdayInstructors){
         allInstructors.add(tuesInstructor);
        }

        for(Instructor thursInstructor:thursdayInstructors){
            allInstructors.add(thursInstructor);
        }

       Instructors instructorsDelTech=new Instructors(allInstructors);

       return instructorsDelTech;
    }
}
