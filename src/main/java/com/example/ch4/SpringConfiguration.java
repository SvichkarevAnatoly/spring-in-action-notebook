package com.example.ch4;

import com.example.performer.Juggler;
import com.example.performer.Performer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public Performer dukeJava() {
        return new Juggler();
    }
}
