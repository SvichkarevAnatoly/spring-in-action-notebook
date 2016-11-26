package com.example.performer;

import com.example.gear.MagicBox;

public class Magician implements Performer {
    private MagicBox magicBox;

    public Magician() {
    }

    @Override
    public String perform() {
        return magicBox.getContents();
    }

    public void setMagicBox(MagicBox magicBox) {
        this.magicBox = magicBox;
    }
}
