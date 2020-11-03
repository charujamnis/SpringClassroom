package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfig {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(StudentConfig.class);

        Students beanStudents=context.getBean("students",Students.class);
        Student student= (Student) beanStudents.getPersonList().get(2);
        System.out.println("The size of the student list is "+beanStudents.getPersonList().size());
        System.out.println("The name from the student list "+student.getName());
        context.close();
    }
}
