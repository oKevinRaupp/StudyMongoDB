package com.kevinraupp.mongodb.config;

import com.kevinraupp.mongodb.domain.Post;
import com.kevinraupp.mongodb.domain.User;
import com.kevinraupp.mongodb.dto.AuthorDTO;
import com.kevinraupp.mongodb.repository.PostRepository;
import com.kevinraupp.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User user01 = new User("Kevin Raupp", "contato@kevinraupp.com");
        User user02 = new User("teste teste", "teste@gmail.com");
        User user03 = new User("Bob teste", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(user01,user02,user03));

        Post post01 = new Post(sdf.parse("06/04/2003"),"Lorem ipsum","Lorem Ipsum is simply dummy text of the printing " +
                "and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, ",new AuthorDTO(user01));
        Post post02 = new Post(sdf.parse("06/04/2023"),"TITULO!","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",new AuthorDTO(user02));
        postRepository.saveAll(Arrays.asList(post01,post02));

        user01.getPosts().addAll(Arrays.asList(post01,post02));
        userRepository.save(user01);

    }
}
