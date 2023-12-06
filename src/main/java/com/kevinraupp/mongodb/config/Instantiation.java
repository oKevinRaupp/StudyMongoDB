package com.kevinraupp.mongodb.config;

import com.kevinraupp.mongodb.domain.User;
import com.kevinraupp.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User user01 = new User("Kevin Raupp", "contato@kevinraupp.com");
        User user02 = new User("teste teste", "teste@gmail.com");
        User user03 = new User("Bob teste", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(user01,user02,user03));
    }
}
