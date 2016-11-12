package com.example;

import com.example.performer.Performer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Chapter3Test {
    private final ClassPathXmlApplicationContext ctx =
            new ClassPathXmlApplicationContext("com/example/chapter3.xml");

    @Test
    public void extend() throws Exception {
        final Performer stevie = (Performer) ctx.getBean("stevie");

        assertThat(stevie.perform(), is("Somewhere over the rainbow and G"));
    }
}
