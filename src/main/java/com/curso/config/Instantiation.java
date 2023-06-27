package com.curso.config;

import com.curso.domain.Post;
import com.curso.domain.User;
import com.curso.repository.PostRepository;
import com.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PostRepository postRepo;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repo.deleteAll();
        postRepo.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Teste title 1", "Teste body 1", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Teste title 2", "Teste body 2", maria);
        repo.saveAll(Arrays.asList(maria,alex,bob));
        postRepo.saveAll(Arrays.asList(post1,post2));
    }
}
