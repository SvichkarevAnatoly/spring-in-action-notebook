package com.example.ch5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MagicianA implements MindReader {
    private String thoughts;

    @Pointcut("execution(* com.example.ch5.Thinker.thinkOfSomething(String)) " +
            "&& args(thoughts)")
    public void thinking(String thoughts) {
    }

    @Override
    @Before("thinking(thoughts)")
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer’s thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
