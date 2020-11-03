package com.example.demo;

public class Student extends Person implements Learner{
    private double totalStudyTime=0;

    public Student(Long id, String name) {
        super(id, name);
    }

    @Override
    public void learn(double numberOfHours) {
        this.totalStudyTime+=numberOfHours;
    }

    public double getTotalStudyTime(){
        return this.totalStudyTime;
    }
}
