package com.example.performer;

public class Juggler implements Performer {
    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public String perform() {
        return "juggling " + beanBags;
    }
}
