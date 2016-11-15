package com.example.ch5;

import org.aspectj.lang.annotation.*;

@Aspect
public class AudienceA {
    @Pointcut("execution(* com.example.performer.Performer.perform(..))")
    public void performance() {
    }

    @Before("performance")
    public void takeSeats() {
        System.out.println("The audience is taking their seats.");
    }

    @Before("performance")
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their cellphones");
    }

    @AfterReturning("performance")
    public void applaud() {
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance")
    public void demandRefund() {
        System.out.println("Boo! We want our money back!");
    }
}
