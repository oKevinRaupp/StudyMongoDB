package com.kevinraupp.mongodb.services;

import com.kevinraupp.mongodb.domain.Post;
import com.kevinraupp.mongodb.domain.User;
import com.kevinraupp.mongodb.dto.UserDTO;
import com.kevinraupp.mongodb.repository.PostRepository;
import com.kevinraupp.mongodb.repository.UserRepository;
import com.kevinraupp.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    public List<Post> findAll(){
        return postRepository.findAll();
    }
    public Post findByID(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Id not found"));
    }
    public void delete(String id){
        findByID(id);
        postRepository.deleteById(id);
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
    public List<Post> findByBody(String text){
        return postRepository.findByBody(text);
    }
    public List<Post> findByComment(String text){
        return postRepository.findByComment(text);
    }
    public List<Post> findByAuthor(String text){
        return postRepository.findByAuthor(text);
    }
    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 *1000);
        return postRepository.fullSearch(text,minDate,maxDate);
    }

}
