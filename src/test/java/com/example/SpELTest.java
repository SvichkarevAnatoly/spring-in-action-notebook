package com.example;

import com.example.other.Email;
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

    @Test
    public void operatorT() throws Exception {
        final Performer duke2 = (Performer) ctx.getBean("duke2");

        assertThat(duke2.perform(), is("juggling 3"));
    }

    @Test
    public void operatorElvis() throws Exception {
        final Performer duke3 = (Performer) ctx.getBean("duke3");

        assertThat(duke3.perform(), is("juggling 25"));
    }

    @Test
    public void matches() throws Exception {
        final Email adminEmail = (Email) ctx.getBean("adminEmail");

        assertThat(adminEmail.isValidEmail(), is(true));
    }
}
