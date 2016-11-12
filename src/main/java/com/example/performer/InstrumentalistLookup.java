package com.example.performer;

import com.example.gear.Instrument;

public abstract class InstrumentalistLookup implements Performer {
    public String perform() {
        return myInstrument().play();
    }

    public abstract Instrument myInstrument();
}
