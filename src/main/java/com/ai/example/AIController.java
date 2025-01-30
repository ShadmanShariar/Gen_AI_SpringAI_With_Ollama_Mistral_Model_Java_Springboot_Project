package com.ai.example;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins = "http://localhost:5500")
public class AIController {

    private final OllamaChatClient client;

    public AIController(OllamaChatClient client) {
        this.client = client;
    }

    @GetMapping("/prompt")
    public Flux<String> promptResponse(@RequestParam("prompt") String prompt) {
        Flux<String> response = client.stream(prompt);
        return response;
    }
}

