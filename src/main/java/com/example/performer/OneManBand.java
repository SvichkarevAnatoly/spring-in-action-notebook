package com.example.performer;

import com.example.gear.Instrument;

import java.util.Collection;

public class OneManBand implements Performer {
    private Collection<Instrument> instruments;

    @Override
    public String perform() {
        final StringBuilder sb = new StringBuilder();
        for (Instrument instrument : instruments) {
            sb.append(instrument.play()).append('\n');
        }
        return sb.toString();
    }

    public void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments;
    }
}
