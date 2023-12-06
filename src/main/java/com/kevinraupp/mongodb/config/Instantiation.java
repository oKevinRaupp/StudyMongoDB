package com.kevinraupp.mongodb.config;

import com.kevinraupp.mongodb.domain.Post;
import com.kevinraupp.mongodb.domain.User;
import com.kevinraupp.mongodb.dto.AuthorDTO;
import com.kevinraupp.mongodb.dto.CommentDTO;
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
        User user02 = new User("Raupp Kevin", "raupp@gmail.com");
        User user03 = new User("Teste Teste", "teste@test.com");
        userRepository.saveAll(Arrays.asList(user01,user02,user03));

        Post post01 = new Post(sdf.parse("06/04/2003"),"Meu aniversario","ola rede, venho informa-los que hoje é meu aniversario! " +
                "and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, ",new AuthorDTO(user01));
        Post post02 = new Post(sdf.parse("06/04/2023"),"TITULO!","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",new AuthorDTO(user01));
        Post post03 = new Post(sdf.parse("12/12/2012"),"POST NOVO!","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",new AuthorDTO(user02));
        Post post04 = new Post(sdf.parse("11/11/2011"),"NEW POST!","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",new AuthorDTO(user03));

        CommentDTO c01 = new CommentDTO("Teste comentario",sdf.parse("08/04/2003"),new AuthorDTO(user03));
        CommentDTO c02 = new CommentDTO("Feliz aniversario Kevin! ",sdf.parse("07/04/2003"),new AuthorDTO(user02));
        CommentDTO c03 = new CommentDTO("Teste comentario do Kevin, no post do Raupp! ",sdf.parse("07/04/2003"),new AuthorDTO(user01));

        post01.getComments().addAll(Arrays.asList(c01,c02));
        post03.getComments().add(c03);
        postRepository.saveAll(Arrays.asList(post01,post02,post03,post04));

        user01.getPosts().addAll(Arrays.asList(post01,post02));
        user02.getPosts().add(post03);
        user03.getPosts().add(post04);
        userRepository.saveAll(Arrays.asList(user01,user02,user03));

    }
}
