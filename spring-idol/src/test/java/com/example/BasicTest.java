package com.example;

import com.example.gear.NullField;
import com.example.other.Auditorium;
import com.example.other.Stage;
import com.example.other.Ticket;
import com.example.performer.Performer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class BasicTest {
    private final ClassPathXmlApplicationContext ctx =
            new ClassPathXmlApplicationContext("com/example/basic.xml");

    @Test
    public void prototypeDiffObjects() throws Exception {
        final Ticket ticket1 = (Ticket) ctx.getBean("aTicket");
        final Ticket ticket2 = (Ticket) ctx.getBean("aTicket");

        assertThat(ticket1, not(ticket2));
    }

    @Test
    public void singleton() throws Exception {
        final Stage stage1 = (Stage) ctx.getBean("theStage");
        final Stage stage2 = (Stage) ctx.getBean("theStage");

        assertThat(stage1, is(stage2));
    }

    @Test
    public void initMethod() throws Exception {
        final Auditorium auditorium = (Auditorium) ctx.getBean("auditorium");

        assertThat(auditorium.isLightsOn, is(true));
    }

    @Test
    public void constructorArgPrimitive() throws Exception {
        final Performer duke = (Performer) ctx.getBean("duke");

        assertThat(duke.perform(), is("juggling 25"));
    }

    @Test
    public void constructorArgObject() throws Exception {
        final Performer poeticDuke = (Performer) ctx.getBean("poeticDuke");

        assertThat(poeticDuke.perform().contains("juggling 15"), is(true));
        assertThat(poeticDuke.perform().contains("While reciting ..."), is(true));
        assertThat(poeticDuke.perform().contains("Моя душа несется в вышину."), is(true));
    }

    @Test
    public void setValueUsingSetter() throws Exception {
        final Performer kenny = (Performer) ctx.getBean("kenny");

        assertThat(kenny.perform(), is("Jingle Bells and TOOT TOOT TOOT"));
    }

    @Test
    public void setValueUsingSetterInnerComponent() throws Exception {
        final Performer kenny = (Performer) ctx.getBean("kennyWithHisSaxophone");

        assertThat(kenny.perform(), is("Jingle Bells and TOOT TOOT TOOT"));
    }

    @Test
    public void pNameSpace() throws Exception {
        final Performer kenny = (Performer) ctx.getBean("kennyP");

        assertThat(kenny.perform(), is("Jingle Bells and TOOT TOOT TOOT"));
    }

    @Test
    public void list() throws Exception {
        final Performer hank = (Performer) ctx.getBean("hankList");

        assertThat(hank.perform(), is("G\nC\nH\n"));
    }

    @Test
    public void set() throws Exception {
        final Performer hank = (Performer) ctx.getBean("hankSet");

        assertThat(hank.perform(), is("G\nC\nH\n"));
    }

    @Test
    public void map() throws Exception {
        final Performer hank = (Performer) ctx.getBean("hankMap");

        assertThat(hank.perform(), is("guitar : G\n" +
                "cymbal : C\n" +
                "harmonica : H\n"));
    }

    @Test
    public void checkNullValue() throws Exception {
        final NullField aNull = ((NullField) ctx.getBean("null"));

        assertThat(aNull.getObject(), is(nullValue()));
    }
}
