package com.example.demo;

import java.util.List;

public class Classroom {
  //  private List<Instructor> instructorsList;
    //private List<Student> studentsList;
    private Instructors instructors;
    private Students students;
    private double perStudentTeachTime;

    public Classroom(Instructors instructors,Students students){
        this.instructors=instructors;
        this.students=students;
    }

    //public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
    public void hostLecture(Teacher teacher, double numberOfHours){
        teacher.lecture(instructors,numberOfHours);
    }

    public Instructors getInstructors() {
        return instructors;
    }

    public void setInstructors(Instructors instructors) {
        this.instructors = instructors;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}
