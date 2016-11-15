package com.example.ch5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class ContestantIntroducer {
    @DeclareParents(
            value = "com.example.performer.Performer+",
            defaultImpl = GraciousContestant.class
    )
    public static Contestant contestant;
}
