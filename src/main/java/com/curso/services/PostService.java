package com.curso.services;

import com.curso.domain.Post;
import com.curso.repository.PostRepository;
import com.curso.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;
    public Post findById(String id){
        Optional<Post> Post = repo.findById(id);
        return Post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encotrado na base de dados"));
    }
    public List<Post> findByTitle(String text){
        return repo.findByTitle(text);
    }
    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate =  new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text,minDate,maxDate);
    }
}
