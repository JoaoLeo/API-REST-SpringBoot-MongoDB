package com.curso.resources;

import com.curso.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> list = new ArrayList<>();
        User teste1 = new User("1001", "teste1", "teste1@gmail.com");
        User teste2 = new User("1002", "teste2", "teste2@gmail.com");
        list.addAll(Arrays.asList(teste1, teste2));
        return ResponseEntity.ok().body(list);
    }
}
