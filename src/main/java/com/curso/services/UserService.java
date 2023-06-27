package com.curso.services;

import com.curso.domain.User;
import com.curso.dto.UserDTO;
import com.curso.repository.UserRepository;
import com.curso.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public List<User> getAll(){
        List<User> list = repo.findAll();
        return list;
    }
    public User findById(String id){
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encotrado na base de dados"));
    }
    public User insert(User user){
        return repo.insert(user);
    }
    public User fromDTO(UserDTO dto){
        User user = new User(dto.getId(), dto.getName(), dto.getEmail());
        return user;
    }
}
