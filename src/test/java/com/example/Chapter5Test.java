package com.example;

import com.example.performer.Performer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Chapter5Test {
    private static final ClassPathXmlApplicationContext ctx =
            new ClassPathXmlApplicationContext("com/example/chapter5.xml");

    @Test
    public void aspectBeforeAfter() {
        final Performer tom = (Performer) ctx.getBean("tom");
        System.out.println(tom.perform());
    }
}
