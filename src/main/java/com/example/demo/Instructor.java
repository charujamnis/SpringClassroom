package com.example.demo;

import java.util.Iterator;

public class Instructor extends Person implements Teacher {
    private double numberOfHoursPerLearner;
    public Instructor(Long id, String name) {
        super(id, name);
    }

    @Override
    public void teach(Learner learner, double numberOfHours) {
        learner.learn(numberOfHours);
    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
        //get the length of the Learners.
        /*int count=0;
        Iterator<? extends Learner> it=learners.iterator();
        while(it.hasNext()){
            count++;
        }*/
        Integer studentsCount=0;
        for(Learner l:learners){
            studentsCount++;
        }
        this.numberOfHoursPerLearner=numberOfHours/studentsCount;
       for(Learner learner : learners){
           learner.learn(numberOfHoursPerLearner);
        }
    }


    public double getNumberOfHoursPerLearner() {
        return this.numberOfHoursPerLearner;
    }
}
