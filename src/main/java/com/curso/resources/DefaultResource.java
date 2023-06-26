package com.curso.resources;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class DefaultResource {

    @GetMapping
    public ResponseEntity<String> getEndpoint() {
        String responseText = "Bem vindo ao meu projeto, endpoints disponiveis no momento: /users" +
        " <br> Projeto no GitHub: " +
                "<a target=\"_blank\" href=\"https://github.com/JoaoLeo/API-REST-SpringBoot-MongoDB\">" +
                "https://github.com/JoaoLeo/API-REST-SpringBoot-MongoDB" +
                "</a>";

        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(responseText);
    }
}
