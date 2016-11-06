package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        final ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("com/example/spring.xml");

        final Performer duke = (Performer) ctx.getBean("duke");
        duke.perform();

        final Performer poeticDuke = (Performer) ctx.getBean("poeticDuke");
        poeticDuke.perform();
    }
}
