package com.example;

import com.example.performer.Performer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpELTest {
    private final ClassPathXmlApplicationContext ctx =
            new ClassPathXmlApplicationContext("com/example/SpEL.xml");

    @Test
    public void literalsAndArithmetic() throws Exception {
        final Performer duke = (Performer) ctx.getBean("duke");

        assertThat(duke.perform(), is("juggling 25"));
    }

    @Test
    public void callMethod() throws Exception {
        final Performer kenny = (Performer) ctx.getBean("kenny");

        assertThat(kenny.perform(), is("25 and TOOT TOOT TOOT"));
    }

    @Test
    public void callIfNotNull() throws Exception {
        final Performer kenny = (Performer) ctx.getBean("kenny2");

        assertThat(kenny.perform(), is("25 and TOOT TOOT TOOT"));
    }
}
