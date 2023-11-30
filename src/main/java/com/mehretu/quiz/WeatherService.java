package com.mehretu.quiz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class WeatherService {
    private final WebClient webClient;

    @Value("${openMeteoAPI.url}")
    private String openMeteoAPIUrl;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("").build();
    }

    public Mono<String> getCurrentWeather() {
        return webClient.get()
                .uri("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m")
                .retrieve()
                .bodyToMono(String.class);

    }
}
