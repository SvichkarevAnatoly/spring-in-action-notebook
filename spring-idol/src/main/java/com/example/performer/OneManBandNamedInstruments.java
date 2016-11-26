package com.example.performer;

import com.example.gear.Instrument;

import java.util.Map;

public class OneManBandNamedInstruments implements Performer{
    private Map<String, Instrument> instruments;

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public String perform() {
        final StringBuilder sb = new StringBuilder();
        for (String instrumentName : instruments.keySet()) {
            sb.append(instrumentName).append(" : ");
            final Instrument instrument = instruments.get(instrumentName);
            sb.append(instrument.play()).append('\n');
        }
        return sb.toString();
    }
}
