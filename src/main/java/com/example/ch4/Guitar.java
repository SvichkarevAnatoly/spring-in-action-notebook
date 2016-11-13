package com.example.ch4;

import com.example.gear.Instrument;
import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument {
    public String play() {
        return "G";
    }
}
