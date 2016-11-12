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

    @Test
    public void methodReplacer() throws Exception {
        final Performer harry = (Performer) ctx.getBean("harry");

        assertThat(harry.perform(), is("A ferocious tiger"));
    }

    @Test
    public void methodLookup() throws Exception {
        final Performer carl = (Performer) ctx.getBean("carl");

        assertThat(carl.perform(), is("G"));
    }
}
