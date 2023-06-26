package com.curso.services;

import com.curso.domain.User;
import com.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public List<User> getAll(){
        List<User> list = repo.findAll();
        return list;
    }
}
