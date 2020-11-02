package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfig {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(StudentConfig.class);

        Students students=context.getBean("students",Students.class);

        System.out.println( "In main config class");
        System.out.println(students.studentsList);

        context.close();
    }
}
