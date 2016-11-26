package com.example.ch4;

import com.example.gear.Instrument;
import com.example.performer.Performer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ch4eddie")
public class Instrumentalist implements Performer {
    @Value("Jingle Bells")
    private String song;
    @Autowired
    private Instrument instrument;

    public String perform() {
        return song + " and " + instrument.play();
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
