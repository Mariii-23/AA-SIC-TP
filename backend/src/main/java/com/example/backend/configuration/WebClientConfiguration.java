package com.example.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {
    @Bean
    public WebClient emailVerifier() {
        WebClient webClient = WebClient
                .builder()
                .baseUrl("https://email-validator8.p.rapidapi.com/api/v2.0/email")
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                    httpHeaders.add("X-RapidAPI-Key", "5e72bb760cmsh292bcfc943dd575p1afe98jsnac204d7ddc64");
                    httpHeaders.add("X-RapidAPI-Host", "email-validator8.p.rapidapi.com");
                        })
                .build();
        return webClient;
    }
}
