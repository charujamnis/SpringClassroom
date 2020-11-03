package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Alumni {
    @Autowired
    @Qualifier("previousCohort")
    Classroom pCohort;


    public Alumni(){
        System.out.println("in Alumni constructor");
    }

    @PostConstruct
    public void executeBootCamp(){
        double numberOfHoursToTeachEachStudent=1200;
        for(int i=0;i<pCohort.getInstructors().getPersonList().size();i++){
            Teacher teacher= (Teacher) pCohort.getInstructors().getPersonList().get(i);
                for(int j=0;j<pCohort.getStudents().getPersonList().size();j++) {
                    Learner learner = (Learner) pCohort.getStudents().getPersonList().get(j);
                    teacher.teach(learner,numberOfHoursToTeachEachStudent);
                }
        }
    }

    public Classroom getpCohort() {
        return pCohort;
    }

    public void setpCohort(Classroom pCohort) {
        this.pCohort = pCohort;
    }
}
