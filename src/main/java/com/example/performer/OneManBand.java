package com.example.performer;

import com.example.gear.Instrument;

public class OneManBand implements Performer {
    private Instrument[] instruments;

    @Override
    public String perform() {
        final StringBuilder sb = new StringBuilder();
        for (Instrument instrument : instruments) {
            sb.append(instrument.play()).append('\n');
        }
        return sb.toString();
    }

    public void setInstruments(Instrument[] instruments) {
        this.instruments = instruments;
    }

    public Instrument[] getInstruments() {
        return instruments;
    }
}
