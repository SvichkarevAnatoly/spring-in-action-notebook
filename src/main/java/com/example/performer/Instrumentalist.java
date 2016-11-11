package com.example.performer;

import com.example.gear.Instrument;

public class Instrumentalist implements Performer {
    private String song;
    private Instrument instrument;

    public String perform() {
        return song + " and " + instrument.play();
    }

    public void setSong(String song) {
        this.song = song;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}