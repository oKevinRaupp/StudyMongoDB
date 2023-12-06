package com.kevinraupp.mongodb.resources;

import com.kevinraupp.mongodb.domain.Post;
import com.kevinraupp.mongodb.domain.User;
import com.kevinraupp.mongodb.dto.UserDTO;
import com.kevinraupp.mongodb.services.PostService;
import com.kevinraupp.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll(){
        List<Post> list = postService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findByID(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id){
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }


}