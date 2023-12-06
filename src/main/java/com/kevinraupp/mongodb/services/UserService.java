package com.kevinraupp.mongodb.services;

import com.kevinraupp.mongodb.domain.User;
import com.kevinraupp.mongodb.dto.UserDTO;
import com.kevinraupp.mongodb.repository.UserRepository;
import com.kevinraupp.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findByID(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Id not found"));
    }
    public User insert(User user){
        return userRepository.insert(user);
    }
    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getName(),userDTO.getEmail());
    }
}
