package com.example.performer;

import com.example.gear.Poem;

public class PoeticJuggler extends Juggler {
    private Poem poem;

    public PoeticJuggler(Poem poem) {
        super();
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public String perform() {
        final String superPerform = super.perform();
        final String beforeReciting = "While reciting ...";
        final String recite = poem.recite();
        return superPerform + '\n' + beforeReciting + '\n' + recite;
    }
}
