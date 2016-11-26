package com.example;

import com.example.performer.Performer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Chapter4Test {
    private final ClassPathXmlApplicationContext ctx =
            new ClassPathXmlApplicationContext("com/example/chapter4.xml");

    @Test
    public void useComponentAnnotation() {
        final Performer eddie = (Performer) ctx.getBean("ch4eddie");
        assertThat(eddie.perform(), is("Jingle Bells and G"));
    }

    @Test
    public void createBeanFromJava() throws Exception {
        final Performer duke = (Performer) ctx.getBean("dukeJava");
        assertThat(duke.perform(), is("juggling 3"));
    }
}
