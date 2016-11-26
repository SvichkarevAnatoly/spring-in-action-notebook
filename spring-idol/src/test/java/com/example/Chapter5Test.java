package com.example;

import com.example.ch5.Contestant;
import com.example.ch5.MindReader;
import com.example.ch5.Thinker;
import com.example.performer.Performer;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Chapter5Test {
    private static final ClassPathXmlApplicationContext ctx =
            new ClassPathXmlApplicationContext("com/example/chapter5.xml");

    @Test
    public void aspectBeforeAfter() {
        final Performer tom = (Performer) ctx.getBean("tom");
        System.out.println(tom.perform());
    }

    @Test
    @Ignore
    public void getArgsUsingAspect() throws Exception {
        final MindReader magician = (MindReader) ctx.getBean("magician");
        final Thinker volunteer = (Thinker) ctx.getBean("volunteer");

        final String thoughts = "Queen of Hearts";
        volunteer.thinkOfSomething(thoughts);

        assertThat(magician.getThoughts(), is(thoughts));
    }

    @Test
    public void addMethod() throws Exception {
        final Performer tom = (Performer) ctx.getBean("tom");
        System.out.println(tom.perform());
        final Contestant tomContestant = (Contestant) tom;
        assertThat(tomContestant.receiveAward(), is("Wow, I win award, thanks"));
    }

    @Test
    public void aspectUsingAnnotations() throws Exception {
        final Performer tom = (Performer) ctx.getBean("tom");
        System.out.println(tom.perform());
    }

    @Test
    public void getArgsUsingAspectUsingAnnotation() throws Exception {
        final MindReader magician = (MindReader) ctx.getBean("magicianA");
        final Thinker volunteer = (Thinker) ctx.getBean("volunteer");

        final String thoughts = "Queen of Hearts";
        volunteer.thinkOfSomething(thoughts);

        assertThat(magician.getThoughts(), is(thoughts));
    }

    @Test
    public void addMethodUsingAnnotation() throws Exception {
        final Performer tom = (Performer) ctx.getBean("tom");
        System.out.println(tom.perform());
        final Contestant tomContestant = (Contestant) tom;
        assertThat(tomContestant.receiveAward(), is("Wow, I win award, thanks"));
    }
}
