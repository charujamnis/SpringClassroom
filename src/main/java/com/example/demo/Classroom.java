package com.example.demo;

import java.util.List;

public class Classroom {
    //private List<Instructor> instructorsList;
  //  private List<Student> studentsList;
    private Instructors instructors;
    private Students students;
    private double perStudentTeachTime;

    //Is it right?
    public Classroom(Instructors instructors,Students students){
   // public Classroom(List<Instructor> instructorsList,List<Student> studentsList){
        this.instructors=instructors;
        this.students=students;
      //  this.instructorsList=instructorsList;
      //  this.studentsList=studentsList;
    }

    //public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
    public void hostLecture(Teacher teacher, double numberOfHours){
        //teacher.lecture(studentsList,numberOfHours);
        teacher.lecture(this.students.personList,numberOfHours);
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
