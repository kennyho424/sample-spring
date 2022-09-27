package com.example.samplespring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpeechConfig {

    @Bean
    public String welcome() {
        return "Hello everyone~";
    }


}
