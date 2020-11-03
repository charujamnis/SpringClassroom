package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Alumni {
    @Autowired
    @Qualifier("previousStudents")
    Students students;

    @Autowired
    @Qualifier("instructorsBean")
    Instructors instructors;

    public Alumni(){
        System.out.println("in Alumni constructor");
    }

    @PostConstruct
    public void executeBootCamp(){
        double numberOfHoursToTeachEachStudent=1200;
        for(int i=0;i<instructors.getPersonList().size();i++){
            Teacher teacher= (Teacher) instructors.getPersonList().get(i);
                for(int j=0;j<students.getPersonList().size();j++) {
                    Learner learner = (Learner) students.getPersonList().get(j);
                    teacher.teach(learner,numberOfHoursToTeachEachStudent);
                }
        }
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Instructors getInstructors() {
        return instructors;
    }

    public void setInstructors(Instructors instructors) {
        this.instructors = instructors;
    }
}
