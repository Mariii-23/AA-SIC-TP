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
                    httpHeaders.add("X-RapidAPI-Key", "2deeaf6164msh2b0460d074803f7p19f042jsn25917196af5e");
                    httpHeaders.add("X-RapidAPI-Host", "email-validator8.p.rapidapi.com");
                        })
                .build();
        return webClient;
    }
}
