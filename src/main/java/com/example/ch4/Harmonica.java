package com.example.ch4;

import com.example.gear.Instrument;
import org.springframework.stereotype.Component;

@Component
@SkipIt
public class Harmonica implements Instrument {
    public String play() {
        return "H";
    }
}
