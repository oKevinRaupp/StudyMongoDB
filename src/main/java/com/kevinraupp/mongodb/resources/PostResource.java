package com.kevinraupp.mongodb.resources;

import com.kevinraupp.mongodb.domain.Post;
import com.kevinraupp.mongodb.domain.User;
import com.kevinraupp.mongodb.dto.UserDTO;
import com.kevinraupp.mongodb.resources.util.URL;
import com.kevinraupp.mongodb.services.PostService;
import com.kevinraupp.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Date;
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

    @RequestMapping(value = "/contains/title",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title",defaultValue = "") String text){
        text = URL.decodeParam(text);

        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value = "/contains/body",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> FindByBody(@RequestParam(value = "body",defaultValue = "") String text){
        text = URL.decodeParam(text);

        List<Post> list = postService.findByBody(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/contains/comment",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByComment(@RequestParam(value = "comment",defaultValue = "") String text){
        text = URL.decodeParam(text);

        List<Post> list = postService.findByComment(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/author",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByAuthor(@RequestParam(value = "author",defaultValue = "") String text){
        text = URL.decodeParam(text);

        List<Post> list = postService.findByAuthor(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/fullsearch",method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text",defaultValue = "") String text,@RequestParam(value = "mindate",defaultValue = "") String minDate,@RequestParam(value = "maxdate",defaultValue = "") String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate,new Date(0L));
        Date max = URL.convertDate(minDate,new Date());
        List<Post> list = postService.fullSearch(text,min,max);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id){
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
