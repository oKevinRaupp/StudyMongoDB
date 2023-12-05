package com.kevinraupp.mongodb.services;

import com.kevinraupp.mongodb.domain.User;
import com.kevinraupp.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
