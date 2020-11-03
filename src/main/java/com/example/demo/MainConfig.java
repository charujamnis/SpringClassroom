package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfig {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(StudentConfig.class);

        Students al=context.getBean("students",Students.class);

        System.out.println( "In main config class");
        //al.setMessage("hey! Hello");
       // System.out.println(al.getMessage());

        context.close();
    }
}
